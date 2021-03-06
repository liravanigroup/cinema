package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.factory.ReservationFactory;
import pl.com.bottega.cinema.api.request.CalculatePriceRequest;
import pl.com.bottega.cinema.api.request.CollectPaymentRequest;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.api.request.GetMoviesAtDateRequest;
import pl.com.bottega.cinema.api.response.*;
import pl.com.bottega.cinema.domain.*;

import java.util.Collection;
import java.util.Set;

import static pl.com.bottega.cinema.domain.validators.ObjectValidator.notNullValidate;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@AllArgsConstructor
@Service
public class CustomerService {

    private PriceCalculator priceCalculator;
    private CinemaCatalog cinemaCatalog;
    private MovieCatalog movieCatalog;
    private ReservationFactory reservationFactory;
    private ReservationRepository reservationRepository;
    private ShowsRepository showsRepository;
    private PaymentManager paymentManager;

    public ListAllCinemasResponse listAll() {
        return new ListAllCinemasResponse(cinemaCatalog.listAll());
    }

    public ListMoviesResponse findMoviesInCinemaByDate(GetMoviesAtDateRequest request) {
        request.validate();
        Collection<Movie> movies = movieCatalog.findMoviesInCinemaByDate(request.getCinemaId(), request.getDate());
        return new ListMoviesResponse(movies);
    }

    public CalculatePriceResponse calculatePrice(CalculatePriceRequest request) {
        request.validate();
        Show show = getExistingShow(request.getShowId());
        return new CalculatePriceResponse(priceCalculator.calculatePrice(request.getTickets(), show));
    }

    @Transactional
    public ReservationResponse createReservation(CreateReservationRequest request) {
        request.validate();
        Show show = getExistingShow(request.getShowId());
        validateSeatSequence(show, request.getSeats());
        Reservation reservation = reservationFactory.createReservation(request, show);
        reservationRepository.save(reservation);
        return new ReservationResponse(reservation.getId());
    }

    private void validateSeatSequence(Show show, Set<Seat> seats) {
        Set<Reservation> reservations = show.getReservations();
        CinemaHall cinemaHall = new CinemaHall(reservations);
        if (!cinemaHall.isAvailableToBuy(seats))
            throw new InvalidRequestException("Seats are occupied");
    }

    @Transactional
    public SeatsResponse getSeatsByShowId(Long showId) {
        Show show = getExistingShow(showId);
        Set<Reservation> reservations = show.getReservations();
        CinemaHall cinemaHall = new CinemaHall(reservations);
        return cinemaHall.getSeatsResponse(); // cinemahall nie moze zwracac seat response
    }

    private Show getExistingShow(Long showId) {
        Show show = showsRepository.load(showId);
        notNullValidate(show, "Show does not exist!");
        return show;
    }

    @Transactional
    public void payForReservedTickets(CollectPaymentRequest request) {
        request.validate();
        Reservation reservation = getExistingReservation(request.getReservationNumber());
        Payment payment = paymentManager.collectPayment(request, reservation);
        reservation.addPayment(payment);
    }

    private Reservation getExistingReservation(Long reservationNumber) {
        Reservation reservation = reservationRepository.load(reservationNumber);
        notNullValidate(reservation, "Reservation does not exists");
        return reservation;
    }
}
package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.factory.ReservationFactory;
import pl.com.bottega.cinema.api.request.CalculatePriceRequest;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.api.request.GetMoviesAtDateRequest;
import pl.com.bottega.cinema.api.request.GetShowProgramAtDateRequest;
import pl.com.bottega.cinema.api.response.CalculatePriceResponse;
import pl.com.bottega.cinema.api.response.ListAllCinemasResponse;
import pl.com.bottega.cinema.api.response.ListMoviesResponse;
import pl.com.bottega.cinema.api.response.ReservationResponse;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.Reservation;

import java.util.Collection;

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

    public ListAllCinemasResponse listAll() {
        return cinemaCatalog.listAll();
    }

    public ListMoviesResponse findMoviesInCinemaByDate(GetMoviesAtDateRequest request) {
        request.validate();
        Collection<Movie> movies = movieCatalog.findMoviesInCinemaByDate(request.getCinemaId(), request.getDate());
        return new ListMoviesResponse(movies);
    }

    public CalculatePriceResponse calculatePrice(CalculatePriceRequest request) {
        request.validate();
        return priceCalculator.calculatePrice(request);
    }

    public ReservationResponse createReservation(CreateReservationRequest request) {
        request.validate();
        Reservation reservation = reservationFactory.createReservation(request);
        return new ReservationResponse(reservation);
    }
}
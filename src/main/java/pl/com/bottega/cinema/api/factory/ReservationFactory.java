package pl.com.bottega.cinema.api.factory;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.PriceCalculator;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Seat;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.util.Set;

/**
 * Created by anna on 24.09.2016.
 */
@Component
public class ReservationFactory {

    private PriceCalculator priceCalculator;

    public Reservation createReservation(CreateReservationRequest request) {

        Long showId = request.getShowId();
        //Set<TicketOrder> tickets = priceCalculator.calculatePrice(showId, request.getTickets());
        Set<Seat> seats = request.getSeats();
        Customer customer = request.getCustomer();

        return new Reservation();
    }
}

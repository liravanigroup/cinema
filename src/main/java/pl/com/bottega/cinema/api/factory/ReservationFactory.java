package pl.com.bottega.cinema.api.factory;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.PriceCalculator;
import pl.com.bottega.cinema.api.request.CalculatePriceRequest;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.api.response.CalculatePriceResponse;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Seat;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.math.BigDecimal;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by anna on 24.09.2016.
 */
@Component
public class ReservationFactory {

    private PriceCalculator priceCalculator;

    public Reservation createReservation(CreateReservationRequest request) {
        Long showId = request.getShowId();
        Set<TicketOrder> tickets = getTicketOrders(request, showId);
        Set<Seat> seats = request.getSeats();
        Customer customer = request.getCustomer();
        BigDecimal totalPrice = getTotalPrice(tickets);

        return new Reservation(tickets, seats, customer, totalPrice);
    }

    private BigDecimal getTotalPrice(Set<TicketOrder> tickets) {
        BigDecimal result = BigDecimal.ZERO;
        tickets.forEach(ticketOrder -> result.add(ticketOrder.getTotalPrice()));
        return result;
    }

    private Set<TicketOrder> getTicketOrders(CreateReservationRequest request, Long showId) {
        request.getTickets();
        return priceCalculator.calculatePrice(showId, request);
    }
}

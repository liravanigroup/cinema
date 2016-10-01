package pl.com.bottega.cinema.api.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.PriceCalculator;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by anna on 24.09.2016.
 */
@AllArgsConstructor
@Component
public class ReservationFactory {

    private PriceCalculator priceCalculator;

    public Reservation createReservation(CreateReservationRequest request, Show show) {
        Set<TicketOrder> tickets = priceCalculator.calculatePrice(request.getTickets(), show);
        return new Reservation(show, tickets, request.getSeats(), request.getCustomer(), getTotalPrice(tickets));
    }

    private BigDecimal getTotalPrice(Set<TicketOrder> tickets) {
        BigDecimal result = BigDecimal.ZERO;
        for (TicketOrder ticket : tickets)
            result = result.add(ticket.getTotalPrice());
        return result;
    }
}

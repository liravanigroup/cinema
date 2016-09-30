package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.CalculatePriceRequest;
import pl.com.bottega.cinema.api.response.CalculatePriceResponse;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.TicketPrice;
import pl.com.bottega.cinema.api.request.dto.TicketDto;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;

/**
 * Created by Admin on 18.09.2016.
 */
@NoArgsConstructor
@Service
public class PriceCalculator {

    public CalculatePriceResponse calculatePrice(CalculatePriceRequest request, Show show) {
        Collection<TicketPrice> tickets = getTicketPrices(show);
        Set<TicketOrder> orders = createOrders(tickets, request.getTickets());
        collectionValidate(orders, "no tickets");
        return new CalculatePriceResponse(orders);
    }

    private Collection<TicketPrice> getTicketPrices(Show show) {
        return show.getMovie().getPrices();
    }

    private Set<TicketOrder> createOrders(Collection<TicketPrice> tickets, Collection<TicketDto> ticketsDto) {
        Set<TicketOrder> order = new HashSet<>();
        for(TicketDto ticketOrder : ticketsDto){
            for(TicketPrice ticketPrice : tickets){
                if (ticketPrice.getType().equals(ticketOrder.getKind()))
                    order.add(new TicketOrder(ticketOrder, ticketPrice));
            }
        }
        return order;
    }

    public Set<TicketOrder> getCalculationSet(Show show, Collection<TicketDto> ticketsDto){
        Collection<TicketPrice> tickets = getTicketPrices(show);
        return createOrders(tickets, ticketsDto);
    }

}

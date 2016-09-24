package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.CalculatePriceRequest;
import pl.com.bottega.cinema.api.response.CalculatePriceResponse;
import pl.com.bottega.cinema.domain.TicketPrice;
import pl.com.bottega.cinema.api.dto.TicketDto;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;

/**
 * Created by Admin on 18.09.2016.
 */
@Service
@AllArgsConstructor
public class PriceCalculator {

    private TicketRepository ticketRepository;

    public CalculatePriceResponse calculatePrice(CalculatePriceRequest request) {
        Collection<TicketPrice> tickets = ticketRepository.load(request.getShowId());
        Set<TicketOrder> orders = createOrders(tickets, request.getTickets());
        collectionValidate(orders, "no tickets");
        return new CalculatePriceResponse(orders);
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

}

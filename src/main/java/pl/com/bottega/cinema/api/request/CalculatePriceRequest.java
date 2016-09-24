package pl.com.bottega.cinema.api.request;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import com.google.common.collect.HashMultiset;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.domain.TicketDto;

import java.util.*;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

@Getter
@Setter
@ToString
public class CalculatePriceRequest {

    private Long showId;
    private Collection<TicketDto> tickets;

    public void validate() {
        entityIdValidate(showId, "Invalid show Id");
        preventDuplicationTicketsType(tickets);
        collectionValidate(tickets, "Tickets is required");
    }

    private void preventDuplicationTicketsType(Collection<TicketDto> tickets) {
        for (TicketDto ticket : tickets) {
            if (getCountDuplicatedTickets(ticket) > 1)
                throw new InvalidRequestException("Duplicated tickets types");
        }
    }

    private int getCountDuplicatedTickets(TicketDto ticket) {
        if (!tickets.contains(ticket))
            throw new InvalidRequestException("Invalid ticket type");
        return HashMultiset.create(tickets).count(ticket);
    }

}

package pl.com.bottega.cinema.api.request;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.com.bottega.cinema.domain.TicketDto;

import java.util.Collection;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;
import static pl.com.bottega.cinema.domain.validators.CollectionValidator.preventDuplicationTicketsType;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

@Getter
@Setter
@ToString
public class CalculatePriceRequest {

    private Long showId;
    private Collection<TicketDto> tickets;

    public void validate() {
        entityIdValidate(showId, "Invalid show Id");
        preventDuplicationTicketsType(tickets, "Duplicated tickets types", "Invalid ticket type");
        collectionValidate(tickets, "Tickets is required");
    }
}

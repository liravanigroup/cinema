package pl.com.bottega.cinema.api.request;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Ticket;

import java.util.Collection;

import static pl.com.bottega.cinema.domain.Validator.collectionValidate;
import static pl.com.bottega.cinema.domain.Validator.entityIdValidate;

@Getter
@Setter
public class CalculatePriceRequest {

    private Long showId;
    private Collection<Ticket> tickets;

    public void validate() {
        entityIdValidate(showId, "Show id is required");
        collectionValidate(tickets, "Tickets is required");
    }

}

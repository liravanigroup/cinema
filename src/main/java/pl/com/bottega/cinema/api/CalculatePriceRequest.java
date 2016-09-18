package pl.com.bottega.cinema.api;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class CalculatePriceRequest {

    private Long showId;

    private Collection<Ticket> tickets;

    public void validate() {
        showIdValidation(showId);
        ticketsValidation(tickets);
    }

    private void ticketsValidation(Collection<Ticket> tickets) {

    }

    private void showIdValidation(Long showId) {

    }

}

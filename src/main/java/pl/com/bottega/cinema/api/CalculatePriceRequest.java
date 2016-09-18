package pl.com.bottega.cinema.api;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class CalculatePriceRequest {

    private Long showId;

    private Collection<Ticket> ticekts;

    public void validate() {
        showIdValidation(showId);
        ticektsValidation(ticekts);
    }

    private void ticektsValidation(Collection<Ticket> ticekts) {

    }

    private void showIdValidation(Long showId) {

    }

}

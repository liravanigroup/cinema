package pl.com.bottega.cinema.api.request;

import lombok.Getter;
import lombok.Setter;

import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
public class GetReservationListRequest {

    private String query, status;

    public void validate() {
        stringValidate(query, "Bad query");
        stringValidate(status, "Invalid status");
    }
}

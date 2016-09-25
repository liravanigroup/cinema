package pl.com.bottega.cinema.api.request;

import lombok.*;

import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetReservationListRequest {

    private String query, status;

    public void validate() {
        stringValidate(query, "");
        stringValidate(status, "");
    }
}

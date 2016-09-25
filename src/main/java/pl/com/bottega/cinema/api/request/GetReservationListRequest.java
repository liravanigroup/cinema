package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Admin on 25.09.2016.
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GetReservationListRequest {

    private String query, status;

    public void validate(){

    }
}

package pl.com.bottega.cinema.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Reservation;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {

    private String reservationNumber;

    public ReservationResponse(Long reservationNumber) {
        this.reservationNumber = reservationNumber.toString();
    }
}

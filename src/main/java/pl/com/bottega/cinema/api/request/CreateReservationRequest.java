package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.ReservationDto;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {

    private ReservationDto reservation;



    public void validate(){
        reservation.validate();
    }
}

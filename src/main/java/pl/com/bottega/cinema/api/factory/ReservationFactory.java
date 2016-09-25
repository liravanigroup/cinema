package pl.com.bottega.cinema.api.factory;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.domain.Reservation;

/**
 * Created by anna on 24.09.2016.
 */
@Component
public class ReservationFactory {

    public Reservation createReservation(CreateReservationRequest request) {
        //return new Reservation(request);
        return null;
   }
}

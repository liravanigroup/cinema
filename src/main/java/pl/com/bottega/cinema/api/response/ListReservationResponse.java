package pl.com.bottega.cinema.api.response;

import pl.com.bottega.cinema.api.dto.ReservationDto;
import pl.com.bottega.cinema.domain.Reservation;

import java.util.Collection;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
public class ListReservationResponse {

    private Collection<ReservationResponseDto> reservations;

    public ListReservationResponse(Collection<Reservation> reservations){

    }
}

package pl.com.bottega.cinema.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Reservation;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@NoArgsConstructor
@Getter
@Setter
public class ListReservationResponse {

    private Collection<ReservationResponseDto> reservations;

    public ListReservationResponse(Collection<Reservation> reservations){
        this.reservations = reservations.stream().map(ReservationResponseDto::new).collect(Collectors.toList());
    }
}

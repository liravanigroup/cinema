package pl.com.bottega.cinema.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Seat;

import java.util.Collection;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class SeatsResponse {

    private Collection<Seat> freeSeats;
    private Collection<Seat> occupiedSeats;
}

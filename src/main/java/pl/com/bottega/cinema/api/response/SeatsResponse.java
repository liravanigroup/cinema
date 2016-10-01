package pl.com.bottega.cinema.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.SeatDto;
import pl.com.bottega.cinema.domain.Seat;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class SeatsResponse {

    private Set<SeatDto> freeSeats;
    private Set<SeatDto> occupiedSeats;

    public SeatsResponse(Set<Seat> occupiedSeats, Set<Seat> freeSeats){
         this.occupiedSeats = occupiedSeats.stream().map(SeatDto::new).collect(Collectors.toSet());
         this.freeSeats = freeSeats.stream().map(SeatDto::new).collect(Collectors.toSet());
     }
}

package pl.com.bottega.cinema.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.SeatDto;
import pl.com.bottega.cinema.domain.Seat;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class SeatsResponse {

    private Collection<SeatDto> freeSeats;
    private Collection<SeatDto> occupiedSeats;



    public SeatsResponse(Collection<Seat> occupiedSeats, Collection<Seat> freeSeats){
         this.occupiedSeats = occupiedSeats.stream().map(SeatDto::new).collect(Collectors.toList());
         this.freeSeats = freeSeats.stream().map(SeatDto::new).collect(Collectors.toList());
     }
}

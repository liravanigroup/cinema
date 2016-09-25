package pl.com.bottega.cinema.api.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Seat;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatResponseDto {
    private Integer row;
    private Integer seat;

    public SeatResponseDto(Seat seat) {
        this(seat.getRow(), seat.getSeat());
    }
}

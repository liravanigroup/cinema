package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class SeatDto {
    private Integer row;
    private Integer seat;
}

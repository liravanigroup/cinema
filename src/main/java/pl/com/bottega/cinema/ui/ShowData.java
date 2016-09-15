package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

/**
 * Created by Admin on 15.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowData {
    private Long cinemaId;
    private LocalTime time;
}

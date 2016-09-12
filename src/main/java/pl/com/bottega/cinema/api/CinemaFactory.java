package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by anna on 06.09.2016.
 */
@Component
public class CinemaFactory {

    public Cinema createCinema(String name, String city) {
        return new Cinema(name, city);
    }
}

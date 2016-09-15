package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by anna on 06.09.2016.
 */
@Component
public class CinemaFactory {

    Cinema createCinema(CreateCinemaRequest request) {
        CinemaDto cinema = request.getCinema();
        return new Cinema(cinema.getCity(), cinema.getName());
    }
}

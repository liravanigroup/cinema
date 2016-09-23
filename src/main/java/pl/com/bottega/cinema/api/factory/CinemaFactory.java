package pl.com.bottega.cinema.api.factory;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.dto.CinemaDto;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by anna on 06.09.2016.
 */
@Component
public class CinemaFactory {
    public Cinema createCinema(CreateCinemaRequest request) {
        return new Cinema(request.getCity(), request.getName());
    }
}

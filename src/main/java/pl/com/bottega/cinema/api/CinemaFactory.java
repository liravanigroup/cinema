package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by anna on 06.09.2016.
 */
public class CinemaFactory {
    public Cinema createCinema(CreateCinemaRequest request) {
        return new Cinema(request.getName(), request.getCity());
    }
}

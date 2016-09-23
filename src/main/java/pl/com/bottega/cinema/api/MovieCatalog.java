package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.response.ListMoviesResponse;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Sergej Povzaniuk on 15.09.2016.
 */
public interface MovieCatalog {
    ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, LocalDate date);
}

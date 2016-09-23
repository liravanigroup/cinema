package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.response.ListMoviesResponse;
import pl.com.bottega.cinema.domain.Movie;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Sergej Povzaniuk on 15.09.2016.
 */
public interface MovieCatalog {
    Collection<Movie> findMoviesInCinemaByDate(Long cinemaId, LocalDate date);
}

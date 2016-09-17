package pl.com.bottega.cinema.api;

import java.time.LocalDate;

/**
 * Created by Sergej Povzaniuk on 15.09.2016.
 */
public interface MovieCatalog {
    ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, LocalDate date);
}

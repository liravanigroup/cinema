package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.ui.ListMoviesResponse;

import java.util.Date;

/**
 * Created by Sergej Povzaniuk on 15.09.2016.
 */
public interface MovieCatalog {
    ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, Date date);
}
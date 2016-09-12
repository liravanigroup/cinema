package pl.com.bottega.cinema.ui;

import pl.com.bottega.cinema.api.CinemaDto;

import java.util.Collection;
import java.util.List;

/**
 * Created by anna on 04.09.2016.
 */
public class ListAllCinemasResponse {

    List<CinemaDto> cinemas;

    public ListAllCinemasResponse(List<CinemaDto> cinemas) {
        this.cinemas = cinemas;
    }

    public List<CinemaDto> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<CinemaDto> cinemas) {
        this.cinemas = cinemas;
    }
}

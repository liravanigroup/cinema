package pl.com.bottega.cinema.ui;

import pl.com.bottega.cinema.api.CinemaDto;

import java.util.Collection;

/**
 * Created by anna on 04.09.2016.
 */
public class ListAllCinemasResponse {

    private Collection<CinemaDto> cinemas;

    public ListAllCinemasResponse(Collection<CinemaDto> cinemas) {
        this.cinemas = cinemas;
    }

    public Collection<CinemaDto> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Collection<CinemaDto> cinemas) {
        this.cinemas = cinemas;
    }
}

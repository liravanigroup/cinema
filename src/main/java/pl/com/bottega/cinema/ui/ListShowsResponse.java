package pl.com.bottega.cinema.ui;

import pl.com.bottega.cinema.api.ShowsDto;

import java.util.Collection;

/**
 * Created by Admin on 14.09.2016.
 */
public class ListShowsResponse {
    private Collection<ShowsDto> shows;

    public ListShowsResponse(Collection<ShowsDto> shows) {
        this.shows = shows;
    }

    public Collection<ShowsDto> getShows() {
        return shows;
    }

    public void setShows(Collection<ShowsDto> shows) {
        this.shows = shows;
    }
}

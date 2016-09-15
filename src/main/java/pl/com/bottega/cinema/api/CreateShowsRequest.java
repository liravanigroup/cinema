package pl.com.bottega.cinema.api;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateShowsRequest {

    private ShowsDto shows;

    public CreateShowsRequest() {
    }

    public CreateShowsRequest(ShowsDto shows) {
        this.shows = shows;
    }

    public ShowsDto getShows() {
        return shows;
    }

    public void setShows(ShowsDto shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "CreateShowsRequest{" +
                "shows=" + shows +
                '}';
    }
}

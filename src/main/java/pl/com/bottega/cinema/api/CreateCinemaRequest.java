package pl.com.bottega.cinema.api;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateCinemaRequest {

    private CinemaDto cinema;

    public CinemaDto getCinema() {
        return cinema;
    }

    public void setCinema(CinemaDto cinema) {
        this.cinema = cinema;
    }

    public void validate() throws InvalidRequestException {
        if (cinema.getName() == null || cinema.getName().length() == 0)
        throw new InvalidRequestException("Cinema name is required!");
        if (cinema.getCity() == null || cinema.getCity().length() == 0)
            throw  new InvalidRequestException("City name is required!");
    }

    public String getName() {
        return cinema.getName();
    }

    public String getCity() {
        return cinema.getCity();
    }


}

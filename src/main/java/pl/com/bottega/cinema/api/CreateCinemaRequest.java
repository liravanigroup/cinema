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

    /**
     * @throws InvalidRequestException if validation is failed and course of exception
     */
    public void validate() {
        cinema.validate();
    }

    public String getName() {
        return cinema.getName();
    }

    public String getCity() {
        return cinema.getCity();
    }
}

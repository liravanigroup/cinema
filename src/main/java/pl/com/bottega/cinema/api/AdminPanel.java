package pl.com.bottega.cinema.api;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class AdminPanel {

    public Cinema createCinema(CreateCinemaRequest request){
        Cinema cinema = new Cinema(request.getCity(), request.getName());
        return cinema;
    }

    public void createMovie(CreateMovieRequest request){

    }

    public void createShow(CreateShowsRequest request){

    }
}

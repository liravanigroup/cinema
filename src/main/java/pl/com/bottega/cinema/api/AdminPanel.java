package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Service
public class AdminPanel {

    private CinemaRepository cinemaRepository;

    public AdminPanel(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public void createCinema(CreateCinemaRequest request){
        Cinema cinema = new Cinema(request.getCity(), request.getName());
        cinemaRepository.save(cinema);

    }

    public void createMovie(CreateMovieRequest request){

    }

    public void createShow(CreateShowsRequest request){

    }
}

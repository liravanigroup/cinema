package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.MovieRepository;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Service
public class AdminPanel {
    private MovieRepository movieRepository;
    private CinemaRepository cinemaRepository;

    public AdminPanel(MovieRepository movieRepository, CinemaRepository cinemaRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Transactional
    public void createCinema(CreateCinemaRequest request){
        Cinema cinema = new Cinema(request.getCinemaDto().getCity(), request.getCinemaDto().getName());
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void createMovie(CreateMovieRequest createMovieRequest) {
        Movie movie = MovieFactory.createMovie(createMovieRequest);
        movieRepository.save(movie);
    }

    public void createShow(CreateShowsRequest request) {

    }
}

package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.MovieRepository;

import javax.persistence.PersistenceException;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Service
public class AdminPanel {

    private MovieRepository movieRepository;
    private CinemaRepository cinemaRepository;
    private CinemaFactory cinemaFactory;

    public AdminPanel(MovieRepository movieRepository, CinemaRepository cinemaRepository, CinemaFactory cinemaFactory) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.cinemaFactory = cinemaFactory;
    }

    @Transactional(rollbackFor = PersistenceException.class)
    public void createCinema(CreateCinemaRequest request) {
        Cinema cinema = cinemaFactory.createCinema(request.getName(), request.getCity());
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void createMovie(CreateMovieRequest createMovieRequest) {
        Movie movie = MovieFactory.createMovie(createMovieRequest);
        movieRepository.save(movie);
    }

    @Transactional
    public void createShow(CreateShowsRequest request) {

    }
}

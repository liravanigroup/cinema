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
    private CinemaFactory cinemaFactory;

    public AdminPanel(MovieRepository movieRepository, CinemaRepository cinemaRepository, CinemaFactory cinemaFactory) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.cinemaFactory = cinemaFactory;
    }

    @Transactional
    public void createCinema(CreateCinemaRequest request) throws InvalidRequestException {
        Cinema cinema = cinemaRepository.load(request.getName(), request.getCity());
        if (cinema == null) {
            cinema = cinemaFactory.createCinema(request.getName(), request.getCity());
            cinemaRepository.save(cinema);
        }
        else
            throw new InvalidRequestException("Cinema already exists!");
    }

    @Transactional
    public void createMovie(CreateMovieRequest createMovieRequest) {
        Movie movie = MovieFactory.createMovie(createMovieRequest);
        movieRepository.save(movie);
    }

    public void createShow(CreateShowsRequest request) {

    }
}

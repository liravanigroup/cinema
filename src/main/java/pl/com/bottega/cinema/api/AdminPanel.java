package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.domain.*;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Service
public class AdminPanel {

    private MovieRepository movieRepository;
    private CinemaRepository cinemaRepository;
    private CinemaFactory cinemaFactory;
    private MovieFactory movieFactory;
    private ShowsFactory showsFactory;
    private ShowsRepository showsRepository;

    public AdminPanel(MovieRepository movieRepository, CinemaRepository cinemaRepository, CinemaFactory cinemaFactory, MovieFactory movieFactory, ShowsFactory showsFactory, ShowsRepository showsRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.cinemaFactory = cinemaFactory;
        this.movieFactory = movieFactory;
        this.showsFactory = showsFactory;
        this.showsRepository = showsRepository;
    }

    @Transactional
    public void createCinema(CreateCinemaRequest request) {
        Cinema cinema = cinemaFactory.createCinema(request);
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void createMovie(CreateMovieRequest createMovieRequest) {
        Movie movie = movieFactory.createMovie(createMovieRequest);
        movieRepository.save(movie);
    }

    @Transactional
    public void createShow(Long cinemaId, CreateShowsRequest request) {
        Collection<Show> shows = showsFactory.createShow(cinemaId, request);
        shows.stream().forEach(show -> showsRepository.save(show));
    }
}

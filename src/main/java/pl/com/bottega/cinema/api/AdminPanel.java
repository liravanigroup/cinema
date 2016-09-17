package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.domain.*;

import java.util.Collection;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@AllArgsConstructor
@Service
public class AdminPanel {

    private MovieRepository movieRepository;
    private CinemaRepository cinemaRepository;
    private CinemaFactory cinemaFactory;
    private MovieFactory movieFactory;
    private ShowsFactory showsFactory;
    private ShowsRepository showsRepository;

    @Transactional
    public void createCinema(CreateCinemaRequest request) {
        request.validate();
        Cinema cinema = cinemaFactory.createCinema(request);
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void createMovie(CreateMovieRequest request) {
        request.validate();
        Movie movie = movieFactory.createMovie(request);
        movieRepository.save(movie);
    }

    @Transactional
    public void createShows(Long cinemaId, CreateShowsRequest request) {
        Collection<Show> shows = showsFactory.createShow(cinemaId, request);
        showsRepository.save(shows);
    }
}

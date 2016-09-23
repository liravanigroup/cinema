package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.factory.CinemaFactory;
import pl.com.bottega.cinema.api.factory.MovieFactory;
import pl.com.bottega.cinema.api.factory.ShowsFactory;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.api.request.CreateMovieRequest;
import pl.com.bottega.cinema.api.request.CreateShowsRequest;
import pl.com.bottega.cinema.api.request.UpdatePricesRequest;
import pl.com.bottega.cinema.domain.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.com.bottega.cinema.domain.validators.Validator.existingValidation;
import static pl.com.bottega.cinema.domain.validators.Validator.notNullValidate;

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
    private ShowsFactory showFactory;
    private ShowsRepository showsRepository;

    @Transactional
    public void createCinema(CreateCinemaRequest request) {
        request.validate();
        preventCinemaDuplication(request);
        Cinema cinema = cinemaFactory.createCinema(request);
        cinemaRepository.save(cinema);
    }

    private void preventCinemaDuplication(CreateCinemaRequest request) {
        Cinema cinema = cinemaRepository.load(request.getName(), request.getCity());
        existingValidation(cinema, String.format("Cinema %s has already been created in %s", request.getName(), request.getCity()));
    }

    @Transactional
    public void createMovie(CreateMovieRequest request) {
        request.validate();
        preventMovieDuplication(request);
        Movie movie = movieFactory.createMovie(request);
        movieRepository.save(movie);
    }

    private void preventMovieDuplication(CreateMovieRequest request) {
        Movie movie = movieRepository.load(request.getTitle(), request.getDescription());
        existingValidation(movie, String.format("Movie %s has already been created", request.getTitle()));
    }

    @Transactional
    public void createShows(CreateShowsRequest request) {
        request.validate();
        Collection<Show> shows = showFactory.createShows(request, getExistingCinema(request.getCinemaId()), getExistingMovie(request.getMovieId()));
        showsRepository.save(getOnlyNewShows(shows));
    }

    private Movie getExistingMovie(Long movieId) {
        Movie movie = movieRepository.load(movieId);
        notNullValidate(movie, "Movie is not exists");
        return movie;
    }

    private Cinema getExistingCinema(Long cinemaId) {
        Cinema cinema = cinemaRepository.load(cinemaId);
        notNullValidate(cinema, "Cinema is not exists");
        return cinema;
    }

    private Collection<Show> getOnlyNewShows(Collection<Show> shows) {
        return shows.stream().filter(show -> null == showsRepository.load(show.getCinema().getId(), show.getMovie().getId(), show.getDate(), show.getTime())).collect(Collectors.toList());
    }

    @Transactional
    public void updatePrices(UpdatePricesRequest request) {
        request.validate();
        Movie movie = getExistingMovie(request.getMovieId());
        movie.updatePrices(getTicketPrices(request, movie));
    }

    private Set<TicketPrice> getTicketPrices(UpdatePricesRequest r, Movie m) {
        return r.getPrices().keySet().stream().map(tn -> new TicketPrice(tn, r.getPrices().get(tn), m)).collect(Collectors.toSet());
    }
}
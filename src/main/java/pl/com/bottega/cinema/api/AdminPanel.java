package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

import static com.google.common.base.Preconditions.checkNotNull;
import static pl.com.bottega.cinema.domain.Validator.existingValidation;
import static pl.com.bottega.cinema.domain.Validator.notNullValidate;

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
        Cinema cinema = cinemaRepository.load(request.getCinema().getName(), request.getCinema().getCity());
        existingValidation(cinema, String.format("Cinema %s has already been created in %s", cinema.getName(), cinema.getCity()));
        cinema = cinemaFactory.createCinema(request);
        cinemaRepository.save(cinema);
    }

    @Transactional
    public void createMovie(CreateMovieRequest request) {
        request.validate();
        Movie movie = movieRepository.load(request.getMovie().getTitle(), request.getMovie().getDescription());
        existingValidation(movie, "Movie has already been created");
        movie = movieFactory.createMovie(request);
        movieRepository.save(movie);
    }

    @Transactional
    public void createShows(CreateShowsRequest request) {
        request.validate();
        Collection<Show> shows = showsFactory.createShow(request);
        showsRepository.save(shows);
    }

    @Transactional
    public void updatePrices(UpdatePricesRequest request) {
        request.validate();
        Movie movie = movieRepository.load(request.getMovieId());
        notNullValidate(movie, "This movie does not exist");
        movie.updatePrices(getTicketPrices(request, movie));
    }

    private Set<TicketPrice> getTicketPrices(UpdatePricesRequest r, Movie m) {
        return r.getPrices().keySet().stream().map(tn -> new TicketPrice(tn, r.getPrices().get(tn), m)).collect(Collectors.toSet());
    }
}

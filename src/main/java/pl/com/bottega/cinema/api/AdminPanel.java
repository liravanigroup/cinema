package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.domain.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

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
        Cinema loadedCinema = cinemaRepository.load(request.getCinema().getName(), request.getCinema().getCity());
        Cinema cinema = new Cinema();
        if (loadedCinema == null) {
            cinema = cinemaFactory.createCinema(request);
        } else {
            throw new InvalidRequestException(
                    String.format("Cinema %s has already been created in %s", cinema.getName(), cinema.getCity())
            );
        }
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

    @Transactional
    public void updatePrices(Long movieId, UpdatePricesRequest request) {
        checkNotNull(request);
        request.validate();
        Movie movie = movieRepository.load(movieId);
        if(movie == null)
            throw new InvalidRequestException("This movie does not exist");
        Set<TicketPrice> ticketPrices = new HashSet<>();
        for (String ticketName : request.getPrices().keySet()){
            ticketPrices.add(new TicketPrice(ticketName, request.getPrices().get(ticketName), movie));
        }
        movie.updatePrices(ticketPrices);
    }
}

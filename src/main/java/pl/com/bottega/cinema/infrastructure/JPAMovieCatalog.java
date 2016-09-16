package pl.com.bottega.cinema.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.MovieRepository;
import pl.com.bottega.cinema.domain.ShowsRepository;
import pl.com.bottega.cinema.ui.ListMoviesResponse;
import pl.com.bottega.cinema.ui.MovieResponseDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 14.09.2016.
 */
@Component
public class JPAMovieCatalog implements MovieCatalog {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ShowsRepository showsRepository;

    @Override
    public ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, LocalDate date) {
        checkNotNull(cinemaId);
        checkNotNull(date);
        List<Movie> movies = findAllMovieByCinemaIdAndDate(cinemaId, date);
        List<MovieResponseDto> moviesResult = movies.stream().map(movie -> {
            MovieResponseDto result = new MovieResponseDto();
            result.setTitle(movie.getTitle());
            result.setDescription(movie.getDescription());
            result.setMinAge(movie.getMinAge());
            result.setLength(movie.getLength());
            result.setActors(movie.getActors());
            result.setGenres(movie.getGenres());
            result.setShows(showsRepository.load(cinemaId, movie.getId(), date));
            return result;
        }).collect(Collectors.toList());
        return new ListMoviesResponse(moviesResult);
    }

    private List<Movie> findAllMovieByCinemaIdAndDate(Long cinemaId, LocalDate date) {
        return entityManager.createQuery("SELECT m FROM Movie m JOIN Show s ON m.id = s.movie.id JOIN Cinema c ON c.id = s.cinema.id WHERE c.id=:cinemaId AND s.date=:date", Movie.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("date", date)
                .getResultList();
    }
}

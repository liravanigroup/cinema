package pl.com.bottega.cinema.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.ShowsRepository;
import pl.com.bottega.cinema.ui.ListMoviesResponse;
import pl.com.bottega.cinema.ui.MovieResponseDto;
import pl.com.bottega.cinema.ui.ShowData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
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
        List<MovieResponseDto> moviesResult = getMovieResponseDtoList(cinemaId, date, movies);
        return new ListMoviesResponse(moviesResult);
    }

    private List<MovieResponseDto> getMovieResponseDtoList(Long cinemaId, LocalDate date, List<Movie> movies) {
        return movies.stream().map(movie -> {
            MovieResponseDto result = new MovieResponseDto();
            result.setTitle(movie.getTitle());
            result.setDescription(movie.getDescription());
            result.setMinAge(movie.getMinAge());
            result.setLength(movie.getLength());
            result.setActors(movie.getActors());
            result.setGenres(movie.getGenres());
            result.setShows(getSortedShows(cinemaId, date, movie));
            return result;
        }).sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
    }

    private List<ShowData> getSortedShows(Long cinemaId, LocalDate date, Movie movie) {
        return showsRepository.load(cinemaId, movie.getId(), date).stream().sorted((o1, o2) -> {
            LocalTime time1 = o1.getTime();
            LocalTime time2 = o2.getTime();
            if (time1.isAfter(time2))
                return 1;
            if (time1.isBefore(time2))
                return -1;
            return 0;
        }).collect(Collectors.toList());
    }

    private List<Movie> findAllMovieByCinemaIdAndDate(Long cinemaId, LocalDate date) {
        return entityManager.createQuery("SELECT DISTINCT m FROM Movie m JOIN Show s ON m.id = s.movie.id JOIN Cinema c ON c.id = s.cinema.id WHERE c.id=:cinemaId AND s.date=:date", Movie.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("date", date)
                .getResultList();
    }
}

package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.ui.ListMoviesResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 14.09.2016.
 */
@Component
public class JPAMovieCatalog implements MovieCatalog{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, Date date) {
        checkNotNull(cinemaId);
        checkNotNull(date);

        System.out.println(cinemaId);
        System.out.println(date);

        List<Movie> movies = entityManager.createQuery(
                "SELECT m FROM Movie AS m JOIN Show AS s ON m.id = s.movie.id JOIN Cinema AS c ON c.id = s.cinema.id WHERE c.id=:cinemaId AND s.date=:date", Movie.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("date", date)
                .getResultList();

        System.out.println(movies);

        return new ListMoviesResponse(null);
    }
}

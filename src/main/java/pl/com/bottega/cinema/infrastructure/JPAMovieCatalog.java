package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Admin on 14.09.2016.
 */
@Component
public class JPAMovieCatalog implements MovieCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Movie> findMoviesInCinemaByDate(Long cinemaId, LocalDate date) {
        return entityManager.createNamedQuery("Movie.findByCinemaIdAndDate", Movie.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("date", date)
                .getResultList();
    }
}
package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.ui.ListMoviesResponse;
import pl.com.bottega.cinema.ui.MovieResponseDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 14.09.2016.
 */
@Component
public class JPAMovieCatalog implements MovieCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, Date date) {
        checkNotNull(cinemaId);
        checkNotNull(date);

        String jpql = "SELECT new pl.com.bottega.cinema.ui.MovieResponseDto(" +
                "m.title," +
                "m.description, " +
                "m.actors," +
                "m.genres," +
                "m.minAge," +
                "m.length, shows), new pl.com.bottega.cinema.ui.ShowData(" +
                "s.id, s.date) AS shows " +
                "FROM Movie AS m JOIN Show AS s ON m.id = s.movie.id JOIN Cinema AS c ON c.id = s.cinema.id WHERE c.id=:cinemaId AND s.date=:date";

        Query query = entityManager.createQuery(jpql, MovieResponseDto.class);
        List<MovieResponseDto> movies = query.setParameter("cinemaId", cinemaId).setParameter("date", date).getResultList();
        return new ListMoviesResponse(movies);
    }
}

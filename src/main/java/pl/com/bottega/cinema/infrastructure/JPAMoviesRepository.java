package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Repository
public class JPAMoviesRepository implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Movie movie) {
        entityManager.merge(movie);
    }

    @Override
    public Movie load(Long movieId) {
        if(movieId == null)
            throw new InvalidRequestException("Movie id is required");
        return entityManager.find(Movie.class, movieId);
    }
}

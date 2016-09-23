package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Repository
public class JPAMoviesRepository implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public Movie load(Long movieId) {
        return entityManager.find(Movie.class, movieId);
    }

    @Override
    public Movie load(String title, String description) {
        List<Movie> movies =  entityManager.createNamedQuery("Movie.findByTitleAndDescription", Movie.class)
                .setParameter("title", title)
                .setParameter("descr", description)
                .getResultList();
       return movies.isEmpty() ? null : movies.get(0);
    }
}

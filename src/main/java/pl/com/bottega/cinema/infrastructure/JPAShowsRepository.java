package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.ShowsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Admin on 14.09.2016.
 */
@Repository
public class JPAShowsRepository implements ShowsRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Show show) {
        entityManager.merge(show);
    }

    @Override
    public void save(Collection<Show> shows) {
        shows.stream().forEach(this::save);
    }
}

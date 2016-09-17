package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.ShowsRepository;
import pl.com.bottega.cinema.api.ShowData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkNotNull;

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

    @Override
    public Collection<ShowData> load(Long cinemaId, Long movieId, LocalDate date) {
        checkNotNull(cinemaId);
        checkNotNull(movieId);
        checkNotNull(date);

        return entityManager.createQuery("SELECT new pl.com.bottega.cinema.api.ShowData(" +
                "s.id, s.time) FROM Show s WHERE s.cinema.id=:cinemaId AND s.movie.id=:movieId AND s.date=:date", ShowData.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("movieId", movieId)
                .setParameter("date", date)
                .getResultList();
    }
}

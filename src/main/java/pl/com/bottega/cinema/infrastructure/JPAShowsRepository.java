package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.ShowsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

/**
 * Created by Admin on 14.09.2016.
 */
@Repository
public class JPAShowsRepository implements ShowsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Show show) {
        entityManager.persist(show);
    }

    @Override
    public void save(Collection<Show> shows) {
        shows.stream().forEach(this::save);
    }

    public Show load(Long cinemaId, Long movieId, LocalDate date, LocalTime time){
        List<Show> shows = entityManager.createNamedQuery("Show.findShowsByShowParams", Show.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("movieId", movieId)
                .setParameter("date", date)
                .setParameter("time", time)
                .getResultList();
        return shows.isEmpty() ? null : shows.get(0);
    }

}

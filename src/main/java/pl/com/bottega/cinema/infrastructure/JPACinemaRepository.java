package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.CreateCinemaRequest;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Repository
public class JPACinemaRepository implements CinemaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Cinema cinema) {
        try {
            entityManager.persist(cinema);
        } catch (Exception ex) {
            throw new InvalidRequestException(
                    String.format("Cinema %s has already been created in %s", cinema.getName(), cinema.getCity())
            );
        }
    }

    @Override
    public Cinema load(CreateCinemaRequest request) {
        List<Cinema> cinemas = entityManager
                .createQuery("FROM Cinema c WHERE c.name =:name AND c.city =:city ", Cinema.class)
                .setParameter("city", request.getCity())
                .setParameter("name", request.getName())
                .getResultList();
        if (cinemas.isEmpty())
            return null;
        return cinemas.get(0);
    }


}

package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        Cinema loadedCinema = load(cinema.getName(), cinema.getCity());
        System.out.println(loadedCinema);
        if (loadedCinema == null) {
            entityManager.persist(cinema);
        } else {
            throw new InvalidRequestException(
                    String.format("Cinema %s has already been created in %s", cinema.getName(), cinema.getCity())
            );
        }
    }

    @Override
    public Cinema load(String name, String city) {
        List<Cinema> cinemas = entityManager.createQuery("FROM Cinema c WHERE c.name =:name AND c.city =:city ", Cinema.class)
                .setParameter("name", name)
                .setParameter("city", city)
                .getResultList();
        if (cinemas.size() != 0) {
            return cinemas.get(0);
        }
        return null;
    }

    @Override
    public Cinema load(Long cinemaId) {
        return entityManager.find(Cinema.class, cinemaId);
    }


}

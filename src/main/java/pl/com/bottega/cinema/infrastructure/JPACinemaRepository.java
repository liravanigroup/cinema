package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
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
        entityManager.persist(cinema);
    }

    @Override
    public Cinema load(String name, String city) {
        List<Cinema> cinemas = entityManager
                .createQuery("FROM Cinema c WHERE c.name =:name AND c.city =:city ", Cinema.class)
                .setParameter("city", name)
                .setParameter("name", city)
                .getResultList();
        if (cinemas.isEmpty())
            return null;
        return cinemas.get(0);
    }

    @Override
    public Cinema load(Long cinemaId) {
        return entityManager.find(Cinema.class, cinemaId);
    }


}

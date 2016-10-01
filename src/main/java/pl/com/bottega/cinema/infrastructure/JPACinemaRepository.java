package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static pl.com.bottega.cinema.infrastructure.JPACommonCode.getSingleObject;

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
        List<Cinema> cinemas = entityManager.createNamedQuery("Cinema.findByNameAndCity", Cinema.class)
                .setParameter("name", name)
                .setParameter("city", city)
                .getResultList();
        return getSingleObject(cinemas);
    }

    @Override
    public Cinema load(Long cinemaId) {
        return entityManager.find(Cinema.class, cinemaId);
    }
}

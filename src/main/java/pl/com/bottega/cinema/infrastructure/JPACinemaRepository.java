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
        return getSingleCinema(cinemas);
    }

    private Cinema getSingleCinema(List<Cinema> cinemas) {
        return cinemas.isEmpty() ? null : cinemas.get(0);
    }

    @Override
    public Cinema load(Long cinemaId) {
        return entityManager.find(Cinema.class, cinemaId);
    }


    /**
     * Created by Admin on 25.09.2016.
     */
    @Repository
    public static class JPAReservationRepository implements ReservationRepository {

        @PersistenceContext
        private EntityManager entityManager;


        @Override
        public void save(Reservation reservation) {
            entityManager.persist(reservation);
        }

        @Override
        public Reservation load(Long showId, Customer customer) {
            return null;
        }
    }
}

package pl.com.bottega.cinema.infrastructure;


import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;
import pl.com.bottega.cinema.domain.ReservationStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by anna on 24.09.2016.
 */
@Repository
public class JPAReservationRepository implements ReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Reservation reservation) {
        entityManager.persist(reservation);
    }


    @Override
    public List<Reservation> load(String lastName, ReservationStatus status) {
        return entityManager.createNamedQuery("Reservation.findByCustomerLastNameAndStatus", Reservation.class)
                .setParameter("lastName", lastName)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public Reservation load(Long reservationNumber) {
        return entityManager.find(Reservation.class, reservationNumber);
    }
}

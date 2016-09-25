package pl.com.bottega.cinema.infrastructure;


import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;

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
    public Reservation load(Long showId, Customer customer) {
        List<Reservation> reservations = entityManager.createNamedQuery("Reservation.findByShowIdAndCustomer", Reservation.class)
                .setParameter("showId", showId)
                .setParameter("firstName", customer.getFirstName())
                .setParameter("lastName", customer.getLastName())
                .getResultList();
        return getSingleReservation(reservations);
    }

    @Override
    public Reservation load(String lastName, String status) {
        List<Reservation> reservations = entityManager.createNamedQuery("Reservation.findByCustomerLastNameAndStatus", Reservation.class)
                .setParameter("firstName", lastName)
                .setParameter("status", status)
                .getResultList();
        return getSingleReservation(reservations);
    }

    private Reservation getSingleReservation(List<Reservation> reservations) {
        return reservations.isEmpty() ? null : reservations.get(0);
    }
}

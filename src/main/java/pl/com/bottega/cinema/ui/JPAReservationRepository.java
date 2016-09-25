package pl.com.bottega.cinema.ui;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.domain.ReservationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Admin on 25.09.2016.
 */
@Repository
public class JPAReservationRepository implements ReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;



}

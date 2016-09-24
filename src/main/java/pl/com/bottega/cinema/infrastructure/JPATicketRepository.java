package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.TicketRepository;
import pl.com.bottega.cinema.domain.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 24.09.2016.
 */
@Repository
public class JPATicketRepository implements TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Collection<Ticket> load(Long showId) {
        return entityManager.createNamedQuery("Ticket.findByShowId", Ticket.class)
                .setParameter("showId", showId)
                .getResultList();
    }
}

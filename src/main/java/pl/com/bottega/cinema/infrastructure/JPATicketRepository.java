package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.TicketRepository;
import pl.com.bottega.cinema.domain.TicketPrice;

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
    public Collection<TicketPrice> load(Long showId) {
        return entityManager.createNamedQuery("TicketPrice.findByShowId", TicketPrice.class)
                .setParameter("showId", showId)
                .getResultList();
    }
}

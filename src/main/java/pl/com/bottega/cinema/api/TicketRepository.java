package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Ticket;

import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 24.09.2016.
 */
public interface TicketRepository {
    Collection<Ticket> load(Long showId);
}

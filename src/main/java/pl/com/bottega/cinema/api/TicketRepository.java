package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.TicketPrice;

import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 24.09.2016.
 */
public interface TicketRepository {
    Collection<TicketPrice> load(Long showId);
}

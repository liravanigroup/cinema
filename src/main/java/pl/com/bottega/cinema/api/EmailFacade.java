package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Reservation;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
public interface EmailFacade {

    void sendTickets(Reservation reservation);
}

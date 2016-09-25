package pl.com.bottega.cinema.domain;

import pl.com.bottega.cinema.api.Customer;

import java.util.List;

/**
 * Created by anna on 24.09.2016.
 */
public interface ReservationRepository {
    void save(Reservation reservation);

    Reservation load(Long showId, Customer customer);

    List<Reservation> load(String lastName, String status);
}

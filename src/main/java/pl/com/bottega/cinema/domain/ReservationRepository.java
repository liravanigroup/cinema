package pl.com.bottega.cinema.domain;

import pl.com.bottega.cinema.api.Customer;

import java.util.List;

/**
 * Created by anna on 24.09.2016.
 */
public interface ReservationRepository {
    void save(Reservation reservation);

    List<Reservation> load(String lastName, ReservationStatus status);

    Reservation load(Long reservationNumber);
}

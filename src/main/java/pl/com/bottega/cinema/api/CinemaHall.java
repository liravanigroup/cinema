package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.response.SeatsResponse;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Seat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by anna on 24.09.2016.
 */
public class CinemaHall {

    private Collection<Reservation> reservations;
    private SeatsResponse seatsResponse;

    public CinemaHall(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Collection<Seat> getFreeSeats() {
        Collection<Seat> seats = new ArrayList<>();
        fieldSeats(seats);
        mergeWithOccupied(seats);
        return seats;
    }

    private void mergeWithOccupied(Collection<Seat> seats) {
        seats.addAll(getOccupiedSeats());
    }

    private void fieldSeats(Collection<Seat> seats) {
        for (int row = 0; row < 15; row++) {
            for (int seat = 0; seat < 10; seat++) {
                seats.add(new Seat(row, seat, true));
            }
        }
    }

    public Collection<Seat> getOccupiedSeats() {
        Collection<Seat> result = new LinkedList<>();
        for (Reservation reservation : reservations) {
            for (Seat seat : reservation.getSeats()) {
                result.add(seat);
            }
        }
        return result;
    }

    public SeatsResponse getSeatsResponse() {
        return new SeatsResponse(getOccupiedSeats(), getFreeSeats());
    }
}

package pl.com.bottega.cinema.api;

import com.google.common.collect.Lists;
import pl.com.bottega.cinema.api.response.SeatsResponse;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Seat;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by anna on 24.09.2016.
 */
public class CinemaHall {

    public static final int SEATS_COUNT = 15;
    public static final int ROWS_COUNT = 10;
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
        for (int row = 0; row < ROWS_COUNT; row++) {
            for (int seat = 0; seat < SEATS_COUNT; seat++) {
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

    public boolean isAvailableToBuy(Set<Seat> seats) {
        if (seats.size() == 1)
            return isFree(new LinkedList<>(seats).get(0));
        if (countOfFreeSeats() < seats.size())
            return false;
        Seat[][] seatArray = new Seat[ROWS_COUNT][SEATS_COUNT];
        getOccupiedSeats().forEach(seat -> seatArray[seat.getRow() - 1][seat.getSeat() - 1] = seat);
return true;
    }

    private int countOfFreeSeats() {
        return getFreeSeats().size();
    }

    private boolean isFree(Seat seat) {
        return !getOccupiedSeats().contains(seat);
    }
}

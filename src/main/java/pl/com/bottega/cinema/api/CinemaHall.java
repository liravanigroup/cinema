package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.response.SeatsResponse;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Seat;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anna on 24.09.2016.
 */
public class CinemaHall {

    private static final int SEATS_COUNT = 15;
    private static final int ROWS_COUNT = 10;
    private Set<Reservation> reservations;

    public CinemaHall(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    private Set<Seat> getFreeSeats() {
        Set<Seat> freeSeats = new HashSet<>();
        fillSeats(freeSeats);
        freeSeats.removeAll(getOccupiedSeats());
        return freeSeats;
    }

    private void fillSeats(Set<Seat> freeSeats) {
        for (int row = 1; row <= ROWS_COUNT; row++) {
            for (int seat = 1; seat <= SEATS_COUNT; seat++)
                freeSeats.add(new Seat(row, seat));
        }
    }

    private Set<Seat> getOccupiedSeats() {
        Set<Seat> occupiedSeats = new HashSet<>();
        for (Reservation reservation : reservations)
            occupiedSeats.addAll(reservation.getSeats());
        return occupiedSeats;
    }

    public SeatsResponse getSeatsResponse() {
        return new SeatsResponse(getOccupiedSeats(), getFreeSeats());
    }

    public boolean isAvailableToBuy(Set<Seat> seats) {
        isFreeValidate(seats);
        return isNearbyPlaces(seats) || !isEnoughNearbySeats(seats);
    }

    private boolean isEnoughNearbySeats(Set<Seat> seats) {
        int neededNearbyCount = seats.size();
        int actualNearbyCount = 0;
        Set<Seat> freeSeats = getFreeSeats();
        for (int row = 1; row <= ROWS_COUNT; row++) {
            for (int seat = 1; seat <= SEATS_COUNT; seat++) {
                if (freeSeats.contains(new Seat(row, seat))) {
                    actualNearbyCount++;
                } else {
                    if (actualNearbyCount >= neededNearbyCount)
                        return true;
                    actualNearbyCount = 0;
                }
            }
            if (actualNearbyCount >= neededNearbyCount)
                return true;
            actualNearbyCount = 0;
        }
        return false;
    }

    private void isFreeValidate(Set<Seat> seats) {
        if (!getFreeSeats().containsAll(seats))
            throw new InvalidRequestException("Some places are already occupied");
    }

    private boolean isNearbyPlaces(Set<Seat> seats) {
        Seat[] seatsArray = seats.toArray(new Seat[seats.size()]);
        for (int index = 0; index < seats.size() - 1; index++) {
            if (!seatsArray[index].getRow().equals(seatsArray[seatsArray.length - 1].getRow())) {
                return false;
            }
        }
        return true;
    }
}
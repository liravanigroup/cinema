package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.request.dto.ReservationDto;
import pl.com.bottega.cinema.api.request.dto.TicketDto;
import pl.com.bottega.cinema.domain.Seat;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {

    private ReservationDto reservation;

    public void validate(){
        reservation.validate();
    }

    public Long getShowId() {
        return reservation.getShowId();
    }

    public Customer getCustomer() {
        return new Customer(reservation.getCustomer());
    }

    public Set<TicketDto> getTickets() {
        return reservation.getTickets();
    }

    public Set<Seat> getSeats() {
        return reservation.getSeats().stream()
                .map(seatDto -> new Seat(seatDto.getRow(), seatDto.getSeat()))
                .collect(Collectors.toSet());
    }
}

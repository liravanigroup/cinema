package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.dto.ReservationDto;
import pl.com.bottega.cinema.api.dto.SeatDto;
import pl.com.bottega.cinema.domain.Seat;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

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

    public Set<TicketOrder> getTickets() {
        return reservation.getTickets();
    }

    public Set<Seat> getSeats() {
        return reservation.getSeats().stream().map(seatDto -> new Seat(seatDto.getRow(), seatDto.getSeat(), true))
                .collect(Collectors.toSet());

    }
}

package pl.com.bottega.cinema.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.CustomerDto;
import pl.com.bottega.cinema.api.response.dto.MovieShortResponseDto;
import pl.com.bottega.cinema.api.response.dto.SeatResponseDto;
import pl.com.bottega.cinema.api.response.dto.ShowResponseDto;
import pl.com.bottega.cinema.api.response.dto.TicketOrderResponseDto;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.Seat;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {
    private Long number;
    private ShowResponseDto show;
    private MovieShortResponseDto movie;
    private Collection<TicketOrderResponseDto> tickets;
    private Collection<SeatResponseDto> seats;
    private CustomerDto customer;
    private String status;
    private BigDecimal totalPrice;

    public ReservationResponseDto(Reservation r) {
        this.number = r.getId();
        this.show = new ShowResponseDto(r.getShow());
        this.movie = new MovieShortResponseDto(r.getShow());
        this.tickets = getTicketOrdersResponse(r);
        this.seats = getSeatsResponceDto(r.getSeats());
        this.customer = new CustomerDto(r.getCustomer());
        this.status = r.getStatus();
        this.totalPrice = r.getTotalPrice();
    }

    private Collection<SeatResponseDto> getSeatsResponceDto(Set<Seat> seats) {
        return seats.stream().map(SeatResponseDto::new).collect(Collectors.toList());
    }

    private Collection<TicketOrderResponseDto> getTicketOrdersResponse(Reservation reservation) {
        return reservation.getTicekts().stream().map(TicketOrderResponseDto::new).collect(Collectors.toList());
    }
}

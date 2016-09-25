package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.util.Collection;
/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ReservationDto {
    private Long showId;
    private Collection<TicketOrder> ticekts;
    private Collection<SeatDto> seats;
    private CustomerDto customer;
}

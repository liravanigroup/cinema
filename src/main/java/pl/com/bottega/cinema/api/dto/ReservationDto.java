package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.util.Collection;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ReservationDto {
    private Long showId;
    private Collection<TicketOrder> tickets;
    private Collection<SeatDto> seats;
    private CustomerDto customer;

    public void validate(){
        entityIdValidate(showId, "Show id is required");
        collectionValidate(tickets, "Tickets are required");
        collectionValidate(seats, "Seats are required");
        customer.validate();
    }
}

package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.math.BigDecimal;
import java.util.Collection;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.priceValidation;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ReservationDto {
    private Long showId;
    private Collection<TicketOrder> tickets;
    private Collection<SeatDto> seats;
    private CustomerDto customer;
    private BigDecimal totalPrice;

    public void validate(){
        entityIdValidate(showId, "Show id is required");
        collectionValidate(tickets, "Tickets are required");
        collectionValidate(seats, "Seats are required");
        customer.validate();
        priceValidation(totalPrice, "Total price is required");
    }
}

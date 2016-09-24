package pl.com.bottega.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Admin on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class TicketOrder {
    private String kind;
    private Integer count;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private TicketOrder(String kind, Integer count, BigDecimal unitPrice){
        this(kind, count, unitPrice, unitPrice.multiply(new BigDecimal(count)));
    }

    public TicketOrder(TicketDto ticketOrder, Ticket ticketPrice) {
        this(ticketOrder.getKind(), ticketOrder.getCount(), ticketPrice.getPrice());
    }
}

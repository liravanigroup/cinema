package pl.com.bottega.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.TicketDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Admin on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TicketOrder {

    @Id
    @GeneratedValue
    private Long id;
    private String kind;
    private Integer count;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private TicketOrder(String kind, Integer count, BigDecimal unitPrice){
        this(null, kind, count, unitPrice, unitPrice.multiply(new BigDecimal(count)));
    }

    public TicketOrder(TicketDto ticketOrder, TicketPrice ticketPrice) {
        this(ticketOrder.getKind(), ticketOrder.getCount(), ticketPrice.getPrice());
    }
}

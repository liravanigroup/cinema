package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.request.dto.TicketDto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Admin on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Entity
public class TicketOrder implements Serializable{

    private static final long serialVersionUID = -1179533539276086449L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private TicketOrder(String kind, Integer count, BigDecimal unitPrice){
        this(null, kind, count, unitPrice, unitPrice.multiply(new BigDecimal(count)));
    }

    public TicketOrder(TicketDto ticketOrder, TicketPrice ticketPrice) {
        this(ticketPrice.getType(), ticketOrder.getCount(), ticketPrice.getPrice());
    }
}

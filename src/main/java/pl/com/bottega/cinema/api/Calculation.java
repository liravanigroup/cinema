package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Admin on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class Calculation {
    private BigDecimal total;
    private Set<TicketOrder> tickets;
}

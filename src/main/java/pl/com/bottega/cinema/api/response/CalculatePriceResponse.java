package pl.com.bottega.cinema.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.Calculation;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Admin on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculatePriceResponse {

    private Calculation calculation;

    public CalculatePriceResponse(Set<TicketOrder> orders) {
        BigDecimal totalCoast = getTotalCoast(orders);
        this.calculation = new Calculation(orders, totalCoast);
    }

    private BigDecimal getTotalCoast(Set<TicketOrder> orders) {
        BigDecimal result = BigDecimal.ZERO;
        for (TicketOrder ticket : orders)
            result = result.add(ticket.getTotalPrice());
        return result;
    }

}

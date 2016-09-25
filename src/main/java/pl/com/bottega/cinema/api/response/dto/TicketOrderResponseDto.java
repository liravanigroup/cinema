package pl.com.bottega.cinema.api.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.TicketOrder;

import java.math.BigDecimal;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketOrderResponseDto {
    private String kind;
    private Integer count;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    public TicketOrderResponseDto(TicketOrder ticket) {
        this(ticket.getKind(), ticket.getCount(), ticket.getUnitPrice(), ticket.getTotalPrice());
    }
}

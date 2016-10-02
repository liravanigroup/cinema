package pl.com.bottega.cinema.api.request.dto;

import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.CreditCard;
import pl.com.bottega.cinema.domain.PaymentType;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Getter
@Setter
public class PaymentDto {

    private PaymentType type;
    private Long cashierId;
    private CreditCard creditCard;
}

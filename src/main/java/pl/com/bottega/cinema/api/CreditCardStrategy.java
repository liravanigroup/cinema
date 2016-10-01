package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.request.dto.PaymentDto;
import pl.com.bottega.cinema.domain.Payment;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public Payment pay(PaymentDto paymentDto) {
        return null;
    }
}

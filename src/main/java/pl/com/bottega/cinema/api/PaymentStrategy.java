package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.request.dto.PaymentDto;
import pl.com.bottega.cinema.domain.Payment;
import pl.com.bottega.cinema.domain.Reservation;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
public interface PaymentStrategy {
    Payment pay(PaymentDto paymentDto, Reservation reservation);
}

package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.request.dto.PaymentDto;
import pl.com.bottega.cinema.domain.Payment;
import pl.com.bottega.cinema.domain.PaymentType;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.TransactionData;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
public class CashStrategy implements PaymentStrategy {

    private static final String CURRENCY = "usd";
    private static final boolean PAYMENT_SUCCESS = true;
    private static final String PAYMENT_STATUS = "successes";


    @Override
    public Payment pay(PaymentDto payment, Reservation reservation) {
        return new Payment(
                PaymentType.CASH,
                payment.getCashierId(),
                PAYMENT_SUCCESS,
                new TransactionData(
                        reservation,
                        CURRENCY,
                        PAYMENT_STATUS,
                        getDescription(payment, reservation)
                )
        );
    }

    private String getDescription(PaymentDto payment, Reservation reservation) {
        return String.format(
                "Payment for reservation #%s; Movie: %s; Seats: %s; provided by cashier: %s",
                reservation.getId(),
                reservation.getShow().getMovie().getTitle(),
                reservation.getSeats(),
                payment.getCashierId()
        );

    }
}

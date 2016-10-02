package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.api.request.dto.PaymentDto;
import pl.com.bottega.cinema.domain.*;

import java.time.LocalDateTime;
import java.util.Date;

import static pl.com.bottega.cinema.domain.PaymentStatus.SUCCEEDED;
import static pl.com.bottega.cinema.domain.PaymentType.CASH;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
public class CashStrategy implements PaymentStrategy {

    private static final String CURRENCY = "usd";

    @Override
    public Payment pay(PaymentDto payment, Reservation reservation) {
        return new Payment(
                CASH,
                payment.getCashierId(),
                new TransactionData(
                        reservation,
                        CURRENCY,
                        SUCCEEDED,
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

package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.CollectPaymentRequest;
import pl.com.bottega.cinema.domain.Payment;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationStatus;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Service
public class PaymentManager {

    private PaymentStrategy paymentStrategy;

    public Payment collectPayment(CollectPaymentRequest request, Reservation reservation) {
        reservationStateValidation(reservation);
        setPaymentStrategy(request.getPayment().getType());
        return paymentStrategy.pay(request.getPayment(), reservation);
    }

    private void reservationStateValidation(Reservation reservation) {
        if (reservation.getStatus() != ReservationStatus.PENDING &&
                reservation.getStatus() != ReservationStatus.PAYMENT_FAILED)
            throw new InvalidRequestException("Reservation is not pending or payment_failed");
    }

    private void setPaymentStrategy(String paymentStrategy) {
        if (paymentStrategy.equals("cash"))
            this.paymentStrategy = new CashStrategy();
        else if (paymentStrategy.equals("credit_card"))
            this.paymentStrategy = new CreditCardStrategy();
        else
            throw new InvalidRequestException("Payment method is incorrect");
    }
}

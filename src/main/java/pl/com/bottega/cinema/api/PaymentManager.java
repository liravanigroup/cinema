package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.domain.Payment;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;

import static pl.com.bottega.cinema.domain.validators.ObjectValidator.notNullValidate;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Service
@AllArgsConstructor
public class PaymentManager {

    private ReservationRepository reservationRepository;
    private PaymentStrategy paymentStrategy;

    public void collectPayment(Long reservationNumber, CollectPaymentRequest request) {
        Reservation reservation = getExistingReservation(reservationNumber);
        Payment payment = new Payment(request.getPaymentDto().getType(), request.getPaymentDto().getCashierId());
        reservation.addPayment(payment);
        reservationRepository.save(reservation);
    }

    private Reservation getExistingReservation(Long reservationNumber) {
        Reservation reservation = reservationRepository.load(reservationNumber);
        notNullValidate(reservation, "Reservation does not exists");
        return reservation;
    }
}

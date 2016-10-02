package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.request.GetReservationListRequest;
import pl.com.bottega.cinema.api.response.ListReservationResponse;
import pl.com.bottega.cinema.domain.PDFGenerator;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;
import pl.com.bottega.cinema.domain.ReservationStatus;
import pl.com.bottega.cinema.domain.*;
import pl.com.bottega.cinema.infrastructure.EmailFacadeImpl;


import java.util.List;

import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;
import static pl.com.bottega.cinema.domain.validators.ObjectValidator.notNullValidate;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@AllArgsConstructor
@Service
public class CashierService {

    private ReservationRepository reservationRepository;
    private PDFGenerator pdfGenerator;
    private EmailFacade emailFacade;
    private CashStrategy cashStrategy;
    private CreditCardStrategy creditCardStrategy;

    public ListReservationResponse getReservations(GetReservationListRequest request) {
        request.validate();
        return new ListReservationResponse(getReservationsList(request));
    }

    private List<Reservation> getReservationsList(GetReservationListRequest request) {
        return reservationRepository.load(request.getQuery(), ReservationStatus.valueOf(request.getStatus().toUpperCase()));
    }

    @Transactional
    public void createPayment(Long reservationNumber, CollectPaymentRequest collectPaymentRequest) {// TODO: 02.10.2016 validacja
        Reservation reservation = getExistingReservation(reservationNumber);
        Payment payment = processPayment(collectPaymentRequest);
        reservation.addPayment(payment);
        reservationRepository.save(reservation);
        if (reservation.isPaid() && payment.isOnline()) {
            emailFacade.sendTickets(reservation);
        }
    }

    private Payment processPayment(CollectPaymentRequest collectPaymentRequest) {

        if (collectPaymentRequest.getPaymentDto().getType().equals(PaymentType.CASH))
            return cashStrategy.pay(collectPaymentRequest.getPaymentDto());
        else
            return creditCardStrategy.pay(collectPaymentRequest.getPaymentDto());
    }

    public ResponseEntity<byte[]> getTicketsInPdf(Long reservationNumber) {
        entityIdValidate(reservationNumber, "Reservation id is incorrect");
        Reservation reservation = getExistingReservation(reservationNumber);
        reservationStateValidation(reservation);
        byte[] reservationPDF = pdfGenerator.getReservationInPDF(reservation);
        return new ResponseEntity<byte[]>(reservationPDF, HttpStatus.OK);
    }

    private void reservationStateValidation(Reservation reservation) {
        if (reservation.getStatus().equals(ReservationStatus.PAID))
            throw new InvalidRequestException("Reservation is not paied");
    }

    private Reservation getExistingReservation(Long reservationNumber) {
        Reservation reservation = reservationRepository.load(reservationNumber);
        notNullValidate(reservation, "Reservation does not exists");
        return reservation;
    }
}

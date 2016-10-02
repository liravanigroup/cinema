package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.request.CollectPaymentRequest;
import pl.com.bottega.cinema.api.request.GetReservationListRequest;
import pl.com.bottega.cinema.api.response.ListReservationResponse;
import pl.com.bottega.cinema.domain.*;

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
    private PdfGenerator pdfGenerator;
    private EmailFacade emailFacade;
    private PaymentManager paymentManager;

    public ListReservationResponse getReservations(GetReservationListRequest request) {
        request.validate();
        return new ListReservationResponse(getReservationsList(request));
    }

    private List<Reservation> getReservationsList(GetReservationListRequest request) {
        return reservationRepository.load(request.getQuery(), ReservationStatus.valueOf(request.getStatus().toUpperCase()));
    }

    @Transactional
    public void createPayment(CollectPaymentRequest request) {
        request.validate();
        Reservation reservation = getExistingReservation(request.getReservationNumber());
        Payment payment = paymentManager.collectPayment(request, reservation);
        reservation.addPayment(payment);
        if (reservation.isPaid() && payment.isPayedByCard())
            emailFacade.sendTickets(reservation);
    }

    @Transactional
    public ResponseEntity<byte[]> getTicketsInPdf(Long reservationNumber) {
        entityIdValidate(reservationNumber, "Reservation id is incorrect");
        Reservation reservation = getExistingReservation(reservationNumber);
        reservationStateValidation(reservation);
        byte[] reservationPDF = pdfGenerator.getReservationInPDF(reservation);
        return new ResponseEntity<byte[]>(reservationPDF, HttpStatus.OK);
    }

    private void reservationStateValidation(Reservation reservation) {
        if(reservation.getStatus() == ReservationStatus.PAID)
            throw new InvalidRequestException("Reservation is not payed");
    }

    private Reservation getExistingReservation(Long reservationNumber) {
        Reservation reservation = reservationRepository.load(reservationNumber);
        notNullValidate(reservation, "Reservation does not exists");
        return reservation;
    }
}

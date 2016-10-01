package pl.com.bottega.cinema.api;

import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.GetReservationListRequest;
import pl.com.bottega.cinema.api.response.ListReservationResponse;
import pl.com.bottega.cinema.domain.PDFGenerator;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;
import pl.com.bottega.cinema.domain.ReservationStatus;

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

    public ListReservationResponse getReservations(GetReservationListRequest request) {
        request.validate();
        return new ListReservationResponse(getReservationsList(request));
    }

    private List<Reservation> getReservationsList(GetReservationListRequest request) {
        return reservationRepository.load(request.getQuery(), ReservationStatus.valueOf(request.getStatus().toUpperCase()));
    }

    public ResponseEntity<byte[]> getTicketsInPdf(Long reservationNumber) {
        entityIdValidate(reservationNumber, "Reservation id is incorrect");
        Reservation reservation = getExistingReservation(reservationNumber);
        reservationStateValidation(reservation);
        byte[] reservationPDF = pdfGenerator.getReservationInPDF(reservation);
        return new ResponseEntity<byte[]>(reservationPDF, HttpStatus.OK);
    }

    private void reservationStateValidation(Reservation reservation) {
        if(reservation.getStatus().equals(ReservationStatus.PAID))
            throw new InvalidRequestException("Reservation is not paied");
    }

    private Reservation getExistingReservation(Long reservationNumber) {
        Reservation reservation = reservationRepository.load(reservationNumber);
        notNullValidate(reservation, "Reservation does not exists");
        return reservation;
    }
}

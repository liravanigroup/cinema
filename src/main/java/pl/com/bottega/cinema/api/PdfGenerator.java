package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Reservation;

/**
 * Created by Admin on 02.10.2016.
 */
public interface PdfGenerator {
    byte[] getReservationInPDF(Reservation reservation);
}

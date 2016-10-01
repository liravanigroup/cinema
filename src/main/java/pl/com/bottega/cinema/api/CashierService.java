package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.GetReservationListRequest;
import pl.com.bottega.cinema.api.response.ListReservationResponse;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;
import pl.com.bottega.cinema.domain.ReservationStatus;

import java.util.List;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@AllArgsConstructor
@Service
public class CashierService {

    private ReservationRepository reservationRepository;

    public ListReservationResponse getReservations(GetReservationListRequest request) {
        request.validate();
        return new ListReservationResponse(getReservationsList(request));
    }

    private List<Reservation> getReservationsList(GetReservationListRequest request) {
        return reservationRepository.load(request.getQuery(), ReservationStatus.valueOf(request.getStatus().toUpperCase()));
    }
}

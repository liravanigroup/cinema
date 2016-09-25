package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.GetReservationListRequest;
import pl.com.bottega.cinema.domain.Reservation;
import pl.com.bottega.cinema.domain.ReservationRepository;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@AllArgsConstructor
@Service
public class CashierService {

    private ReservationRepository reservationRepository;

    public Reservation getReservations(GetReservationListRequest request){
        request.validate();
        Reservation reservation = reservationRepository.load()
    }
}

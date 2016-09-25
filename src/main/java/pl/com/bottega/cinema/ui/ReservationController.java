package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CashierService;
import pl.com.bottega.cinema.api.CustomerService;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;
import pl.com.bottega.cinema.api.request.GetReservationListRequest;

/**
 * Created by anna on 24.09.2016.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private CustomerService customerService;
    private CashierService cashierService;

    @PutMapping
    public void createReservation(@RequestBody CreateReservationRequest request) {
        customerService.createReservation(request);
    }

    @GetMapping
    public void getReservationByQuery(@ModelAttribute GetReservationListRequest request){
        cashierService.getReservations(request);
    }


}

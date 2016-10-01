package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinema.api.CustomerService;
import pl.com.bottega.cinema.api.response.SeatsResponse;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/shows")
public class ShowController {

    private CustomerService customerService;

    @GetMapping("/{showId}/seats")
    public SeatsResponse getSeats(@PathVariable("showId") Long showId){
        return customerService.getSeatsByShowId(showId);
    }
}

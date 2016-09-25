package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinema.api.CustomerService;

/**
 * Created by bernard.boguszewski on 25.09.2016.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/shows")
public class ShowController {

    private CustomerService customerService;

    @GetMapping("/{showId}/seats")
    public void getSeats(@PathVariable("showId") Long showId){
        customerService.getSeatsByShowId(showId);
    }
}

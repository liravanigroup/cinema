package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CustomerService;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.api.request.GetMoviesAtDateRequest;
import pl.com.bottega.cinema.api.response.ListAllCinemasResponse;
import pl.com.bottega.cinema.api.response.ListMoviesResponse;


/**
 * Created by anna on 04.09.2016.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    private AdminPanel adminPanel;
    private CustomerService customerService;

    @PutMapping
    public void create(@RequestBody CreateCinemaRequest request) {
        adminPanel.createCinema(request);
    }

    @GetMapping
    public ListAllCinemasResponse listAll() {
        return customerService.listAll();
    }

    @GetMapping("/{cinemaId}/movies")
    public ListMoviesResponse findMoviesAtDate(@PathVariable("cinemaId") Long cinemaId,
                                               @RequestParam("date") GetMoviesAtDateRequest request) {
        request.setCinemaId(cinemaId);
        return customerService.findMoviesInCinemaByDate(request);
    }
}
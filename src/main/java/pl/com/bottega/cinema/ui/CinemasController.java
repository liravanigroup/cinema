package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.CreateCinemaRequest;
import pl.com.bottega.cinema.api.MovieCatalog;

import java.util.Date;

/**
 * Created by anna on 04.09.2016.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    private AdminPanel adminPanel;
    private CinemaCatalog cinemaCatalog;
    private MovieCatalog movieCatalog;

    @PutMapping
    public void create(@RequestBody CreateCinemaRequest request) {
        request.validate();
        adminPanel.createCinema(request);
    }

    @GetMapping
    public ListAllCinemasResponse listAll() {
        return cinemaCatalog.listAll();
    }

    @GetMapping("/{cinemaId}/movies")
    public ListMoviesResponse findMoviesAtDate(@PathVariable("cinemaId") Long cinemaId, Date date) {
        return movieCatalog.findMoviesInCinemaByDate(cinemaId, date);
    }
}

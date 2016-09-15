package pl.com.bottega.cinema.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.CreateCinemaRequest;
import pl.com.bottega.cinema.infrastructure.JPAMovieCatalog;

import java.time.LocalDateTime;

/**
 * Created by anna on 04.09.2016.
 */
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    private AdminPanel adminPanel;
    private CinemaCatalog cinemaCatalog;
    private JPAMovieCatalog showsCatalog;

    public CinemasController(AdminPanel adminPanel, CinemaCatalog cinemaCatalog) {
        this.adminPanel = adminPanel;
        this.cinemaCatalog = cinemaCatalog;
    }

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
    public ListShowsResponse findShows(@PathVariable("cinemaId") Long id, LocalDateTime date) {
        System.out.println(id);
        System.out.println(date);
        return null;
    }
}

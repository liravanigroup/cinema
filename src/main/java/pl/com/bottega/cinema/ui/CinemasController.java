package pl.com.bottega.cinema.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.CreateCinemaRequest;
import pl.com.bottega.cinema.domain.CinemaRepository;

/**
 * Created by anna on 04.09.2016.
 */
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    private AdminPanel adminPanel;
    private CinemaRepository cinemaRepository;
    private CinemaCatalog cinemaCatalog;

    public CinemasController(AdminPanel adminPanel, CinemaRepository cinemaRepository) {
        this.adminPanel = adminPanel;
        this.cinemaRepository = cinemaRepository;
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
}

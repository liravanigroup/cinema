package pl.com.bottega.cinema.ui;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CreateCinemaRequest;
import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by anna on 04.09.2016.
 */
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    private AdminPanel adminPanel;

    public CinemasController(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    @PutMapping
    public void create(@RequestBody CreateCinemaRequest request) {
        adminPanel.createCinema(request);
    }

    public ListAllCinemasResponse listAll() {
        return null;
    }
}

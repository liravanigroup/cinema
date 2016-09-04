package pl.com.bottega.cinema.ui;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CreateMovieRequest;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private AdminPanel adminPanel;

    public MoviesController(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    @PutMapping
    public void create(@RequestBody CreateMovieRequest createMovieRequest) {
        System.out.println(createMovieRequest);
        createMovieRequest.validate();
        adminPanel.createMovie(createMovieRequest);
    }


}

package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CreateShowsRequest;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */
@RestController
@RequestMapping("/cinemas")
@AllArgsConstructor
public class ShowsController {

    private AdminPanel adminPanel;

    @PutMapping("/{cinemaId}/shows")
    public void create(@PathVariable("cinemaId") Long cinemaId, @RequestBody CreateShowsRequest request){
        adminPanel.createShows(cinemaId, request);
    }
}

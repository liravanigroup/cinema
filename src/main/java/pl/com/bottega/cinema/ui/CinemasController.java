package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.UserService;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.api.request.GetShowProgramAtDateRequest;
import pl.com.bottega.cinema.api.response.ListAllCinemasResponse;
import pl.com.bottega.cinema.api.response.ListMoviesResponse;

import java.time.LocalDate;


/**
 * Created by anna on 04.09.2016.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemasController {

    private AdminPanel adminPanel;
    private UserService userService;

    @PutMapping
    public void create(@RequestBody CreateCinemaRequest request) {
        adminPanel.createCinema(request);
    }

    @GetMapping
    public ListAllCinemasResponse listAll() {
        return userService.listAll();
    }

    @GetMapping("/{cinemaId}/movies")
    public ListMoviesResponse findMoviesAtDateInCinema(@PathVariable("cinemaId") Long cinemaId, GetShowProgramAtDateRequest request){
        return userService.findMoviesInCinemaByDate(request);
    }
}
package pl.com.bottega.cinema.ui;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CreateMovieRequest;
import pl.com.bottega.cinema.api.UpdatePricesRequest;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MoviesController {

    private AdminPanel adminPanel;

    @PutMapping
    public void create(@RequestBody CreateMovieRequest request) {
        adminPanel.createMovie(request);
    }

    @PutMapping("/{movieId}/prices")
    public void updatePrices(@PathVariable("movieId") Long movieId, @RequestBody UpdatePricesRequest request){
        adminPanel.updatePrices(movieId, request);
    }
}

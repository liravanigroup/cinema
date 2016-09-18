package pl.com.bottega.cinema.ui;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinema.api.CalculatePriceRequest;
import pl.com.bottega.cinema.api.CalculatePriceResponse;
import pl.com.bottega.cinema.api.PriceCalculator;

@RestController
@RequestMapping("/price_calculator")
@AllArgsConstructor
public class PriceCalculateController {

    private PriceCalculator priceCalculator;

    @PostMapping
    public CalculatePriceResponse calculatePrice(@RequestBody CalculatePriceRequest request){
            return priceCalculator.calculatePrice(request);
    }

}

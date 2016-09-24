package pl.com.bottega.cinema.ui;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinema.api.CustomerService;
import pl.com.bottega.cinema.api.request.CalculatePriceRequest;
import pl.com.bottega.cinema.api.response.CalculatePriceResponse;

@RestController
@RequestMapping("/price_calculator")
@AllArgsConstructor
public class PriceCalculateController {

    private CustomerService customerService;

    @PostMapping
    public CalculatePriceResponse calculatePrice(@RequestBody CalculatePriceRequest request) {
        return customerService.calculatePrice(request);
    }
}

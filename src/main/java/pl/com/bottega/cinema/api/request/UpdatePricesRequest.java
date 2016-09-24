package pl.com.bottega.cinema.api.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.containsValuesValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.priceValidation;
import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;

/**
 * Created by anna on 18.09.2016.
 */
@Getter
@Setter
public class UpdatePricesRequest {

    private Map<String, BigDecimal> prices;
    private Long movieId;

    public void validate() {
        containsValuesValidate(prices.keySet(), "TicketPrice type must by regular and student", "regular", "student");
        for (String name : prices.keySet()) {
            stringValidate(name, "TicketPrice type does not exist");
            priceValidation(prices.get(name), "Price must be greater or equal than zero");
        }
    }
}

package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by anna on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class UpdatePricesRequest {

    private Map<String, BigDecimal> prices;

    public void validate(){
        for(String name : prices.keySet()){
            if (!prices.containsKey("regular") || !prices.containsKey("student"))
                throw new InvalidRequestException("Ticket type must by regular or student!");
            if(name == null || name.equals(""))
                throw new InvalidRequestException("Ticket type does not exist!");
            if(prices.get(name) == null || prices.get(name).signum() < 0)
                throw new InvalidRequestException("Price must be greater or equal than zero!");

        }
    }
}

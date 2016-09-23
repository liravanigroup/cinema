package pl.com.bottega.cinema.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.Calculation;

/**
 * Created by Admin on 18.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculatePriceResponse {
    private Calculation calculation;
}

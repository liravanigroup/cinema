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
}

package pl.com.bottega.cinema.api.request;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.TicketPrice;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Sergej Povzaniuk on 24.09.2016.
 */
public class UpdatePricesRequestTest {

    private static final String TYPE = "type";
    private static final BigDecimal PRICE = BigDecimal.valueOf(10);
    private static final Movie MOVIE = new Movie();

    private UpdatePricesRequest request;
    private Map<String, BigDecimal> prices;
    private Movie movie;
    private Set<TicketPrice> ticketPrices;
    private TicketPrice price;


    //String type, BigDecimal price, Movie movie
    @Before
    public void setUp() throws Exception {
        request = new UpdatePricesRequest();
        price = new TicketPrice(TYPE, PRICE);

    }

    @Test
    public void shouldAcceptValidation() {
        //given
        //request.setPrices(prices);
        movie.updatePrices(ticketPrices);

        //when
        request.validate();
    }

}
package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.cinema.api.request.dto.CinemaDto;
import pl.com.bottega.cinema.api.factory.CinemaFactory;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.domain.Cinema;

import static org.junit.Assert.assertEquals;

/**
 * Created by bernard.boguszewski on 24.09.2016.
 */
public class CinemaFactoryTest {

    private static final String name = "Cinema City";
    private static final String city = "Lublin";

    private CinemaFactory cinemaFactory;
    private CreateCinemaRequest createCinemaRequest;
    private CinemaDto cinemaDto;

    private static final Cinema RIGHT_CINEMA = new Cinema(city, name);



    @Before
    public void setUp() {
        cinemaFactory = new CinemaFactory();
        cinemaDto = new CinemaDto(name, city);
        createCinemaRequest = new CreateCinemaRequest();
    }

    @Test
    public void shouldCreateMovie() {
        createCinemaRequest.setCinema(cinemaDto);

        Cinema createdCinema = cinemaFactory.createCinema(createCinemaRequest);

        assertEquals(RIGHT_CINEMA, createdCinema);

    }

}

package pl.com.bottega.cinema.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by anna on 06.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class AdminPanelTest {

    @Mock
    private CinemaRepository cinemaRepository;

    @Mock
    private CinemaFactory cinemaFactory;

    @Mock
    Cinema cinema;

    @Test(expected = InvalidRequestExceptionWhenCinemaAlreadyExist.class)
    public void shouldCreateCinema() {
        //given

        //when

        //then

    }
}

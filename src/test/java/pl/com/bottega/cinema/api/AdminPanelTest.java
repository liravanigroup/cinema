package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.MovieRepository;

import static org.mockito.Mockito.*;

/**
 * Created by anna on 06.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class AdminPanelTest {

    @Mock
    private CinemaRepository anyCinemaRepository;

    @Mock
    private MovieRepository anyMovieRepository;

    @Mock
    private CinemaFactory anyCinemaFactory;

    @Mock
    private CreateCinemaRequest anyCreateCinemaRequest;

    @Mock
    private Cinema anyCinema;

    private AdminPanel adminPanel;


    @Before
    public void setUp() {
        adminPanel = new AdminPanel(anyMovieRepository, anyCinemaRepository, anyCinemaFactory);
    }


    @Test
    public void shouldCreateNewCinema() {
        //given
        when(anyCinemaFactory.createCinema(anyCreateCinemaRequest)).thenReturn(anyCinema);

        //when
        adminPanel.createCinema(anyCreateCinemaRequest);

        //then
        verify(anyCinemaRepository).save(anyCinema);
    }


    @Test(expected = InvalidRequestException.class)
    public void shouldThrownInvalidRequestExWhenAddedCinemaAlreadyExists(){
        //given
        doThrow(InvalidRequestException.class).when(anyCinemaRepository).save(anyCinema);

        when(anyCinemaFactory.createCinema(anyCreateCinemaRequest)).thenReturn(anyCinema);
        adminPanel.createCinema(anyCreateCinemaRequest);

        //when
        adminPanel.createCinema(anyCreateCinemaRequest);
    }


}
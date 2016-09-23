package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.cinema.api.factory.MovieFactory;
import pl.com.bottega.cinema.api.factory.ShowsFactory;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.api.request.CreateMovieRequest;
import pl.com.bottega.cinema.api.request.CreateShowsRequest;
import pl.com.bottega.cinema.domain.*;

import java.util.Collection;

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
    private MovieFactory anyMovieFactory;

    @Mock
    private CinemaFactory anyCinemaFactory;

    @Mock
    private ShowsFactory anyShowsFactory;

    @Mock
    private ShowsRepository anyShowsRepository;

    @Mock
    private CreateCinemaRequest anyCreateCinemaRequest;

    @Mock
    private CreateMovieRequest anyCreateMovieRequest;

    @Mock
    private CreateShowsRequest anyCreateShowsRequest;

    @Mock
    private Cinema anyCinema;

    @Mock
    private Movie anyMovie;

    @Mock
    private Collection<Show> anyShow;

    private Long anyCinemaId;

    private AdminPanel adminPanel;

    @Before
    public void setUp() {
        adminPanel = new AdminPanel(anyMovieRepository, anyCinemaRepository,
                anyCinemaFactory, anyMovieFactory, anyShowsFactory, anyShowsRepository);
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
    public void shouldThrownInvalidRequestExWhenAddedCinemaAlreadyExists() {
        //given
        doThrow(InvalidRequestException.class).when(anyCinemaRepository).save(anyCinema);

        when(anyCinemaFactory.createCinema(anyCreateCinemaRequest)).thenReturn(anyCinema);

        //when
        adminPanel.createCinema(anyCreateCinemaRequest);
    }

    @Test
    public void shouldCreateMovie() {
        //given
        when(anyMovieFactory.createMovie(anyCreateMovieRequest)).thenReturn(anyMovie);

        //when
        adminPanel.createMovie(anyCreateMovieRequest);

        //then
        verify(anyMovieRepository).save(anyMovie);
    }

    @Test
    public void shouldCreateShows() {
        //given
        //when(anyShowsFactory.createShows(anyCreateShowsRequest)).thenReturn(anyShow);

        //when
        adminPanel.createShows(anyCreateShowsRequest);

        //then
        verify(anyShowsRepository).save(anyShow);
    }
}

package pl.com.bottega.cinema.acceptance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.*;
import pl.com.bottega.cinema.api.request.dto.CinemaDto;
import pl.com.bottega.cinema.api.request.dto.MovieDto;
import pl.com.bottega.cinema.api.factory.CinemaFactory;
import pl.com.bottega.cinema.api.factory.MovieFactory;
import pl.com.bottega.cinema.api.factory.ShowsFactory;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.api.request.CreateMovieRequest;
import pl.com.bottega.cinema.domain.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anna on 06.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
public class AdminPanelAcceptanceTest {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieFactory movieFactory;

    @Autowired
    private CinemaFactory cinemaFactory;

    @Autowired
    private ShowsFactory showsFactory;

    @Autowired
    private ShowsRepository showsRepository;

    private AdminPanel adminPanel;

    private CinemaDto cinemaDto;

    private static final String name = "Cinema City";
    private static final String city = "Lublin";
    private static final Cinema RIGHT_CINEMA = new Cinema(city, name);
    private static final String anyTitle = "any title";
    private static final String anyDescription = "any description";
    private static final Set<String> anyActorsSet = new HashSet<>(Arrays.asList("any actor1", "any actor2"));
    private static final Set<String> anyGenresSet = new HashSet<>(Arrays.asList("any genre1", "any genre2"));
    private static final Integer anyMinAge = 16;
    private static final int anyLength = 123;
    private static final Movie RIGHT_MOVIE = new Movie(anyTitle, anyDescription, anyMinAge, anyLength, anyActorsSet, anyGenresSet);
    @Before
    public void setUp() {
        adminPanel = new AdminPanel(movieRepository, cinemaRepository,
                cinemaFactory, movieFactory, showsFactory, showsRepository);
    }

    @Test
    @Transactional
    public void shouldCreateCinema(){
        //given
        cinemaDto = new CinemaDto(name, city);
        CreateCinemaRequest request = new CreateCinemaRequest(cinemaDto);

        //when
        adminPanel.createCinema(request);

        //then
        assertNotNull(cinemaRepository.load(name, city));
        assertEquals(RIGHT_CINEMA, cinemaRepository.load(name, city));

    }


    @Test
    @Transactional
    public void shouldCreateMovie(){

        MovieDto movieDto = new MovieDto(anyTitle, anyDescription, anyActorsSet, anyGenresSet, anyMinAge, anyLength);
        CreateMovieRequest request = new CreateMovieRequest(movieDto);

        adminPanel.createMovie(request);

        assertNotNull(movieRepository.load(anyTitle, anyDescription));

    }
}

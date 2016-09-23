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
import pl.com.bottega.cinema.api.factory.MovieFactory;
import pl.com.bottega.cinema.api.factory.ShowsFactory;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.MovieRepository;
import pl.com.bottega.cinema.domain.ShowsRepository;

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

    @Before
    public void setUp() {
        adminPanel = new AdminPanel(movieRepository, cinemaRepository,
                cinemaFactory, movieFactory, showsFactory, showsRepository);
    }

    @Test
    @Transactional
    public void shouldCreateCinema(){
        //given
        adminPanel.createCinema(null);

        //when


        //then


    }


    private CreateCinemaRequest createCinemaRequest(){
        return new CreateCinemaRequest();
    }
}

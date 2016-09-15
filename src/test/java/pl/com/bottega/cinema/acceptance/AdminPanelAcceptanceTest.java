package pl.com.bottega.cinema.acceptance;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.bottega.cinema.api.AdminPanel;
import pl.com.bottega.cinema.api.CinemaFactory;
import pl.com.bottega.cinema.api.MovieFactory;
import pl.com.bottega.cinema.api.ShowsFactory;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.MovieRepository;
import pl.com.bottega.cinema.domain.ShowsRepository;

/**
 * Created by anna on 06.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)
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


}

package pl.com.bottega.cinema.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.ShowsRepository;
import pl.com.bottega.cinema.ui.ListMoviesResponse;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.SEPTEMBER;
import static org.junit.Assert.*;

/**
 * Created by Sergej Povzaniuk on 16.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc.properties", "/hibernate.properties"})
@WebAppConfiguration
public class JPAMovieCatalogTest {

    @Autowired
    private MovieCatalog movieCatalog;


    @Test
    public void ShouldFindMoviesInCinemaByDate() throws Exception {
        //given


        //when
        ListMoviesResponse listMoviesResponse = movieCatalog.findMoviesInCinemaByDate(1L, LocalDate.of(2016, SEPTEMBER, 5));

        //then
        System.out.println(listMoviesResponse);

    }

}
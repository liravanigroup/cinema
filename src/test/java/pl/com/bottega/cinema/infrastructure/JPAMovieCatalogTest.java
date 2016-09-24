package pl.com.bottega.cinema.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.domain.Movie;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sergej Povzaniuk on 16.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc.properties", "/hibernate.properties"})
@WebAppConfiguration
public class JPAMovieCatalogTest {

    public static final int EXPECTED_MOVIE_COUNT = 4;
    private static final LocalDate DATE = LocalDate.of(2016, 10, 11);
    private static final Long CINEMA_ID = 1L;

    @Autowired
    private MovieCatalog movieCatalog;

    @Sql("/fixtures/cinemas.sql")
    @Test
    @Transactional
    public void shouldFindMoviesInCinemaByDate() throws Exception {
        //given

        //when
        Collection<Movie> loadedMovies = movieCatalog.findMoviesInCinemaByDate(CINEMA_ID, DATE);

        //then
        assertEquals(EXPECTED_MOVIE_COUNT, loadedMovies.size());

    }

}
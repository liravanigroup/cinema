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
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Sergej Povzaniuk on 16.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
public class JPACinemaRepositoryTest {

    public static final String CITY_NAME = "Lublin";
    public static final String CINEMA_NAME = "Plaza";
    public static final Long CINEMA_ID = 1L;
    public static final Cinema CINEMA_WITH_ID_1 = new Cinema(1L, CITY_NAME, CINEMA_NAME );

    @Autowired
    private CinemaRepository cinemaRepository;

    @Sql("/fixtures/cinemas.sql")
    @Transactional
    @Test
    public void shouldSaveCinema() {
        //given
        Cinema cinema = new Cinema(CITY_NAME, CINEMA_NAME);

        //when
        cinemaRepository.save(cinema);

        //then
        Cinema loadedCinema = cinemaRepository.load(CINEMA_NAME, CITY_NAME);
        assertEquals(cinema, loadedCinema);
    }

    @Sql("/fixtures/cinemas.sql")
    @Transactional
    @Test
    public void shouldLoadCinemaById() {
        //given

        //when
        Cinema loadedCinema = cinemaRepository.load(CINEMA_ID);

        //then
        assertEquals(CINEMA_WITH_ID_1, loadedCinema);
    }

    @Sql("/fixtures/cinemas.sql")
    @Transactional
    @Test
    public void shouldLoadCinemaByNameAndCity() {
        //given

        //when
        Cinema loadedCinema = cinemaRepository.load(CINEMA_NAME, CITY_NAME);

        //then
        assertEquals(CINEMA_WITH_ID_1, loadedCinema);
    }

    @Transactional
    @Test
    public void shouldReturnNullWhenCinemaIsNotExistsByNameAndCity() {
        //given

        //when
        Cinema loadedCinema = cinemaRepository.load(CINEMA_NAME, CITY_NAME);

        //then
        assertNull(loadedCinema);
    }

    @Transactional
    @Test
    public void shouldReturnNullWhenCinemaIsNotExistsById() {
        //given

        //when
        Cinema loadedCinema = cinemaRepository.load(CINEMA_ID);

        //then
        assertNull(loadedCinema);
    }


}
package pl.com.bottega.cinema.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pl.com.bottega.cinema.api.dto.MovieDto;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.domain.ShowsRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.time.Month.SEPTEMBER;

/**
 * Created by Sergej Povzaniuk on 16.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc.properties", "/hibernate.properties"})
@WebAppConfiguration
@Sql("/fixtures/cinema.sql")
public class JPAShowsRepositoryTest {

    @Autowired
    private ShowsRepository showsRepository;

    private Cinema cinema = new Cinema("Warszawa", "Arkadia");
    private Set<String> actors = new HashSet<String>(Arrays.asList("Johnny", "Maestro"));
    private Set<String> genres = new HashSet<String>(Arrays.asList("drama", "comedy"));
    MovieDto movieDto = new MovieDto("xxx", "yeah", actors,  genres, 16, 123);
    private Movie movie = new Movie(movieDto);
    String str = "2016-10-11 12:30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);


    @Test
    public void save() throws Exception {
        Show show1 = new Show(cinema, movie, dateTime);
        Set<Show> shows = new HashSet<>();
        shows.add(show1);

        showsRepository.save(shows);


    }



}
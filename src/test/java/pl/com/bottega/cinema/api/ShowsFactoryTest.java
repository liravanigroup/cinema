package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.jdbc.Sql;
import pl.com.bottega.cinema.api.request.dto.ShowsDto;
import pl.com.bottega.cinema.api.factory.ShowsFactory;
import pl.com.bottega.cinema.api.request.CreateShowsRequest;
import pl.com.bottega.cinema.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static org.junit.Assert.*;


/**
 * Created by Sergej Povzaniuk on 16.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@Sql("/fixtures/cinema.sql")
public class ShowsFactoryTest {

    private static final Long MOVIE_ID = 1l;
    private static final Long CINEMA_ID = 1L;

    private ShowsFactory showsFactory;

    private CinemaRepository cinemaRepository;
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private Cinema cinema;

    @Mock
    private Movie movie;


    private CreateShowsRequest request;
    private ShowsDto showsDto;

    //LocalDateTime dateTime = LocalDateTime.of(2016, 10, 11, 16, 30);
    LocalDate date = LocalDate.of(2016, 10, 11);
    LocalTime time = LocalTime.of(16, 30);
    private Set<LocalDateTime> dateTimes = new HashSet<>(Arrays.asList(LocalDateTime.of(date, time)));

    private Show rightShow = new Show(cinema, movie, date, time);
    private Collection<Show> rightShowsSet = Collections.singletonList(rightShow);


    @Before
    public void setUp() {
        showsFactory = new ShowsFactory();
        request = new CreateShowsRequest();
        showsDto = new ShowsDto(MOVIE_ID, dateTimes);
    }

    @Test
    public void shouldCreateShow() throws Exception {
        request.setShows(showsDto);
        request.setCinemaId(CINEMA_ID);

        Collection<Show> shows = showsFactory.createShows(request, cinema, movie);

        assertNotNull(shows);
    }

}
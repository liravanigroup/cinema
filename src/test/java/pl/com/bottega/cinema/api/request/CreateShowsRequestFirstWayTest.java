package pl.com.bottega.cinema.api.request;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.com.bottega.cinema.api.request.dto.CalendarDto;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.api.request.dto.ShowsDto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertNull;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
public class CreateShowsRequestFirstWayTest {

    private static final Long MOVIE_ID = 1L;
    private static final Set<LocalDateTime> SHOW_DATES = new HashSet<>(Arrays.asList(
            LocalDateTime.of(2016, 10, 25, 12, 30),
            LocalDateTime.of(2016, 10, 25, 15, 30),
            LocalDateTime.of(2016, 10, 25, 17, 30))
    );

    private static final Long MOVIE_ID_IS_NULL = null;
    private static final Set<LocalDateTime> SHOW_DATES_IS_NULL = null;

    private static final Long MOVIE_ID_IS_NEGATIVE = -1L;
    private static final Set<LocalDateTime> SHOW_DATES_IS_EMPTY = new HashSet<>();

    private CreateShowsRequest request;
    private ShowsDto show;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        request = new CreateShowsRequest();
        show = new ShowsDto(MOVIE_ID, SHOW_DATES);
    }

    @Test
    public void shouldAcceptValidation(){
        //given
        request.setShows(show);

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenShowMovieIdIsNull() {
        //given
        show.setMovieId(MOVIE_ID_IS_NULL);
        request.setShows(show);

        //then
        catchExceptionWithMessage("Movie id is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenShowMovieIdIsNegative() {
        //given
        show.setMovieId(MOVIE_ID_IS_NEGATIVE);
        request.setShows(show);

        //then
        catchExceptionWithMessage("Movie id is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenShowDatesIdIsNull() {
        //given
        show.setDates(SHOW_DATES_IS_NULL);
        request.setShows(show);

        //then
        catchExceptionWithMessage("Show date is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenShowMovieIdIsEmpty() {
        //given
        show.setDates(SHOW_DATES_IS_EMPTY);
        request.setShows(show);

        //then
        catchExceptionWithMessage("Show date is required");

        //when
        request.validate();
    }

    @Test
    public void shouldCheckThatCalendarDtoIsNull() {
        //given


        //when
        CalendarDto calendarDto = show.getCalendar();

        //then
        assertNull(calendarDto);
    }


    private void catchExceptionWithMessage(String exceptionMessage) {
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage(exceptionMessage);
    }
}
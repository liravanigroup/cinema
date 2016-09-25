package pl.com.bottega.cinema.api.request;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.com.bottega.cinema.api.request.dto.CalendarDto;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.api.request.dto.ShowsDto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
public class CreateShowsRequestSecondWayTest {

    private static final Long MOVIE_ID = 1L;
    private static final LocalDateTime FROM_DATE = LocalDateTime.of(2016, 10, 25, 12, 30);
    private static final LocalDateTime UNTIL_DATE = LocalDateTime.of(2016, 11, 25, 12, 30);
    private static final Set<DayOfWeek> DAYS_OF_WEEK = new HashSet<>(Arrays.asList(MONDAY, FRIDAY));
    private static final Set<LocalTime> TIME_OF_SHOWS = new HashSet<>(Arrays.asList(
            LocalTime.of(12, 30),
            LocalTime.of(15, 30),
            LocalTime.of(17, 30))
    );

    private static final Long MOVIE_ID_IS_NULL = null;
    private static final LocalDateTime FROM_DATE_IS_NULL = null;
    private static final LocalDateTime UNTIL_DATE_IS_NULL = null;
    private static final Set<DayOfWeek> DAYS_OF_WEEK_IS_NULL = null;
    private static final Set<LocalTime> TIME_OF_SHOWS_IS_NULL = null;

    private static final Long MOVIE_ID_IS_NEGATIVE = -1L;
    private static final LocalDateTime FROM_DATE_IS_UNTIL = UNTIL_DATE;
    private static final LocalDateTime UNTIL_DATE_IS_FROM = FROM_DATE;
    private static final Set<DayOfWeek> DAYS_OF_WEEK_IS_EMPTY = new HashSet<>();
    private static final Set<LocalTime> TIME_OF_SHOWS_IS_EMPTY = new HashSet<>();

    private CreateShowsRequest request;
    private ShowsDto show;
    private CalendarDto calendar;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        request = new CreateShowsRequest();
        show = new ShowsDto(MOVIE_ID, null);
        calendar = new CalendarDto(FROM_DATE, UNTIL_DATE, DAYS_OF_WEEK, TIME_OF_SHOWS);
    }

    @Test
    public void shouldAcceptValidation() {
        //given
        setRequestParam();

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenShowMovieIdIsNull() {
        //given
        show.setCalendar(calendar);
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
        show.setCalendar(calendar);
        show.setMovieId(MOVIE_ID_IS_NEGATIVE);
        request.setShows(show);

        //then
        catchExceptionWithMessage("Movie id is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarFromDateIsNull(){
        //given
        calendar.setFromDate(FROM_DATE_IS_NULL);
        setRequestParam();

        //then
        catchExceptionWithMessage("First date of movie showing is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarUntilDateIsNull(){
        //given
        calendar.setUntilDate(UNTIL_DATE_IS_NULL);
        setRequestParam();

        //then
        catchExceptionWithMessage("Last date of movie showing is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarUntilDateAndFromDateAreWrongSequence(){
        //given
        calendar.setFromDate(FROM_DATE_IS_UNTIL);
        calendar.setUntilDate(UNTIL_DATE_IS_FROM);
        setRequestParam();

        //then
        catchExceptionWithMessage("Dates sequence is incorrect");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarWeekDaysIsNull(){
        //given
        calendar.setWeekDays(DAYS_OF_WEEK_IS_NULL);
        setRequestParam();

        //then
        catchExceptionWithMessage("Week days of movie showing is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarWeekDaysIsEmpty(){
        //given
        calendar.setWeekDays(DAYS_OF_WEEK_IS_EMPTY);
        setRequestParam();

        //then
        catchExceptionWithMessage("Week days of movie showing is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarHoursIsNull(){
        //given
        calendar.setHours(TIME_OF_SHOWS_IS_NULL);
        setRequestParam();

        //then
        catchExceptionWithMessage("Hours of movie showing is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCalendarHoursIsEmpty(){
        //given
        calendar.setHours(TIME_OF_SHOWS_IS_EMPTY);
        setRequestParam();

        //then
        catchExceptionWithMessage("Hours of movie showing is required");

        //when
        request.validate();
    }

    @Test
    public void shouldCheckThatCalendarDtoIsNull() {
        //given
        show.setCalendar(calendar);

        //when
        CalendarDto calendarDto = show.getCalendar();

        //then
        assertNotNull(calendarDto);
    }

    private void setRequestParam() {
        show.setCalendar(calendar);
        request.setShows(show);
    }

    private void catchExceptionWithMessage(String exceptionMessage) {
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage(exceptionMessage);
    }


}
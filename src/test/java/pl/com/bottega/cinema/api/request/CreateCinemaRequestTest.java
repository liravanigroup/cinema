package pl.com.bottega.cinema.api.request;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.com.bottega.cinema.api.dto.CinemaDto;
import pl.com.bottega.cinema.api.InvalidRequestException;

import static org.mockito.Mockito.doThrow;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
public class CreateCinemaRequestTest {

    private static final String CINEMA_NAME = "cinema";
    private static final String CINEMA_CITY = "city";

    private static final String CINEMA_NAME_IS_NULL = null;
    private static final String CINEMA_CITY_IS_NULL = null;

    private static final String CINEMA_NAME_IS_EMPTY = "";
    private static final String CINEMA_CITY_IS_EMPTY = "";

    private CreateCinemaRequest request;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        request = new CreateCinemaRequest();
    }

    @Test
    public void shouldAcceptValidation(){
        //given
        setRequestStain(CINEMA_NAME, CINEMA_CITY);

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCinemaNameIsNull() {
        //given
        setRequestStain(CINEMA_NAME_IS_NULL, CINEMA_CITY);

        //then
        catchExceptionWithMessage("Cinema name is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCinemaNameIsEmpty() {
        //given
        setRequestStain(CINEMA_NAME_IS_EMPTY, CINEMA_CITY);

        //then
        catchExceptionWithMessage("Cinema name is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCinemaCityIsNull() {
        //given
        setRequestStain(CINEMA_NAME, CINEMA_CITY_IS_NULL);

        //then
        catchExceptionWithMessage("City name is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenCinemaCityIsEmpty() {
        //given
        setRequestStain(CINEMA_NAME, CINEMA_CITY_IS_EMPTY);

        //then
        catchExceptionWithMessage("City name is required");

        //when
        request.validate();
    }

    private void catchExceptionWithMessage(String exceptionMessage) {
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage(exceptionMessage);
    }

    private void setRequestStain(String cinemaName, String cinemaCity) {
        request.setCinema(new CinemaDto(cinemaName, cinemaCity));
    }

}
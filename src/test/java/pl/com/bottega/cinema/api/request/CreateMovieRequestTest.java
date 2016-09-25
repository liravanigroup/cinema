package pl.com.bottega.cinema.api.request;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.api.request.dto.MovieDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
public class CreateMovieRequestTest {

    private static final String MOVIE_TITLE = "title";
    private static final String MOVIE_DESCRIPTION = "description";
    private static final Set<String> MOVIE_ACTORS = new HashSet<>(Arrays.asList("Stalone", "Van Damme", "Statham"));
    private static final Set<String> MOVIE_GENRES = new HashSet<>(Arrays.asList("Triller", "Horror", "Comedy"));
    private static final Integer MOVIE_MIN_AGE = 16;
    private static final Integer MOVIE_LENGTH = 120;

    private static final String MOVIE_TITLE_IS_NULL = null;
    private static final String MOVIE_DESCRIPTION_IS_NULL = null;
    private static final Set<String> MOVIE_ACTORS_IS_NULL = null;
    private static final Set<String> MOVIE_GENRES_IS_NULL = null;
    private static final Integer MOVIE_MIN_AGE_IS_NULL = null;
    private static final Integer MOVIE_LENGTH_IS_NULL = null;

    private static final String MOVIE_TITLE_IS_EMPTY = "";
    private static final String MOVIE_DESCRIPTION_IS_EMPTY = "";
    private static final Set<String> MOVIE_ACTORS_IS_EMPTY = new HashSet<>();
    private static final Set<String> MOVIE_GENRES_IS_EMPTY = new HashSet<>();

    private static final Integer MOVIE_MIN_AGE_IS_NEGATIVE = -16;
    private static final Integer MOVIE_LENGTH_IS_NEGATIVE = -120;

    private static final Integer MOVIE_MIN_AGE_IS_TOO_BIG = 101;
    private static final Integer MOVIE_LENGTH_IS_TOO_BIG = 250;

    private CreateMovieRequest request;
    private MovieDto movie;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        request = new CreateMovieRequest();
        movie = new MovieDto(MOVIE_TITLE, MOVIE_DESCRIPTION, MOVIE_ACTORS, MOVIE_GENRES, MOVIE_MIN_AGE, MOVIE_LENGTH);
    }

    @Test
    public void shouldAcceptValidation(){
        //given
        request.setMovie(movie);

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieTitleIsNull() {
        //given
        movie.setTitle(MOVIE_TITLE_IS_NULL);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Title is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieTitleIsEmpty() {
        //given
        movie.setTitle(MOVIE_TITLE_IS_EMPTY);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Title is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieDescriptionIsNull() {
        //given
        movie.setDescription(MOVIE_DESCRIPTION_IS_NULL);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Description is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieDescriptionIsEmpty() {
        //given
        movie.setDescription(MOVIE_DESCRIPTION_IS_EMPTY);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Description is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieActorsIsNull() {
        //given
        movie.setActors(MOVIE_ACTORS_IS_NULL);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Actors is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieActorsIsEmpty() {
        //given
        movie.setActors(MOVIE_ACTORS_IS_EMPTY);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Actors is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieGenresIsNull() {
        //given
        movie.setGenres(MOVIE_GENRES_IS_NULL);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Genres is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieGenresIsEmpty() {
        //given
        movie.setGenres(MOVIE_GENRES_IS_EMPTY);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Genres is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieMinAgeIsNull() {
        //given
        movie.setMinAge(MOVIE_MIN_AGE_IS_NULL);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Min age is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieMinAgeIsNegative() {
        //given
        movie.setMinAge(MOVIE_MIN_AGE_IS_NEGATIVE);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Min age is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieMinAgeIsTooBig() {
        //given
        movie.setMinAge(MOVIE_MIN_AGE_IS_TOO_BIG);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Min age is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieLengthIsNull() {
        //given
        movie.setLength(MOVIE_LENGTH_IS_NULL);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Length is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieLengthIsNegative() {
        //given
        movie.setLength(MOVIE_LENGTH_IS_NEGATIVE);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Length is required");

        //when
        request.validate();
    }

    @Test
    public void shouldThrownIREWhenMovieLengthIsTooBig() {
        //given
        movie.setLength(MOVIE_LENGTH_IS_TOO_BIG);
        request.setMovie(movie);

        //then
        catchExceptionWithMessage("Length is required");

        //when
        request.validate();
    }

    private void catchExceptionWithMessage(String exceptionMessage) {
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage(exceptionMessage);
    }

}
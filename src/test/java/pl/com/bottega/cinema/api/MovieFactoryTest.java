package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.cinema.api.dto.MovieDto;
import pl.com.bottega.cinema.api.factory.MovieFactory;
import pl.com.bottega.cinema.api.request.CreateMovieRequest;
import pl.com.bottega.cinema.domain.Movie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Sergej Povzaniuk on 16.09.2016.
 */
public class MovieFactoryTest {

    private static final String MOVIE_TITLE = "title";
    private static final String MOVIE_DESCRIPTION = "description";
    private static final Set<String> MOVIE_ACTORS = new HashSet<>(Arrays.asList("Stalone", "Van Damme", "Statham"));
    private static final Set<String> MOVIE_GENRES = new HashSet<>(Arrays.asList("Triller", "Horror", "Comedy"));
    private static final Integer MOVIE_MIN_AGE = 16;
    private static final Integer MOVIE_LENGTH = 120;

    private static final Movie RIGHT_MOVIE = new Movie(MOVIE_TITLE, MOVIE_DESCRIPTION, MOVIE_MIN_AGE, MOVIE_LENGTH, MOVIE_ACTORS, MOVIE_GENRES);

    private MovieFactory movieFactory;
    private CreateMovieRequest request;
    private MovieDto movieDto;

    @Before
    public void setUp() {
        movieFactory = new MovieFactory();
        request = new CreateMovieRequest();
        movieDto = new MovieDto(MOVIE_TITLE, MOVIE_DESCRIPTION, MOVIE_ACTORS, MOVIE_GENRES, MOVIE_MIN_AGE, MOVIE_LENGTH);
    }

    @Test
    public void shouldCreateMovie() {
        //given
        request.setMovie(movieDto);

        //when
        Movie createdMovie = movieFactory.createMovie(request);

        //then
        assertEquals(RIGHT_MOVIE, createdMovie);
    }

}
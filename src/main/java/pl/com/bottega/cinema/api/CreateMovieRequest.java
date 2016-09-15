package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Actor;
import pl.com.bottega.cinema.domain.Genre;

import java.util.Collection;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateMovieRequest {

    private MovieDto movie;

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public void validate() {
        movie.validate();
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public String getDescription() {
        return movie.getDescription();
    }

    public Integer getMinAge() {
        return movie.getMinAge();
    }

    public Collection<Actor> getActors() {
        return movie.getActors();
    }

    public Collection<Genre> getGenres() {
        return movie.getGenres();
    }

    public Integer getLength() {
        return movie.getLength();
    }

    @Override
    public String toString() {
        return "CreateMovieRequest{" +
                "movie=" + movie +
                '}';
    }
}
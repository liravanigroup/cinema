package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Actor;
import pl.com.bottega.cinema.domain.Genre;

import java.util.Collection;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateMovieRequest {

    private String title;
    private String description;
    private Collection<Actor> actors;
    private Collection<Genre> genres;
    private Integer minAge;
    private Integer length;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void validate(String title, String description, Collection<Actor> actors, Collection<Genre> genres, Integer minAge, Integer length) {
        if (title == null)
            throw new InvalidRequestException("Title is required");
        if (description == null)
            throw new InvalidRequestException("Description is required");
        if (actors == null)
            throw new InvalidRequestException("Actors is required");
        if (genres == null)
            throw new InvalidRequestException("Genres is required");
        if (minAge == null)
            throw new InvalidRequestException("Min age is required");
        if (length == null)
            throw new InvalidRequestException("Length is required");
    }
}

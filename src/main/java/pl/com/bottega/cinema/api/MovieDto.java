package pl.com.bottega.cinema.api;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import pl.com.bottega.cinema.domain.Actor;
import pl.com.bottega.cinema.domain.Genre;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieDto {

    private String title;
    private String description;
    private Collection<Actor> actors;
    private Collection<Genre> genres;
    private Integer minAge;
    private Integer length;


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

    public void setActors(Collection<String> actors) {
        this.actors = actors.stream().map(name -> new Actor(name)).collect(Collectors.toList());
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<String> genres) {
        this.genres = genres.stream().map(g -> new Genre(g)).collect(Collectors.toList());
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

    public void validate() {
        if (title == null || title.trim().length() <= 2)
            throw new InvalidRequestException("Title is required");
        if (description == null || description.trim().length() <= 10)
            throw new InvalidRequestException("Description is required");
        if (actors == null || actors.size() <= 0)
            throw new InvalidRequestException("Actors is required");
        if (genres == null || genres.size() <= 0)
            throw new InvalidRequestException("Genres is required");
        if (minAge == null || minAge <= 0)
            throw new InvalidRequestException("Min age is required");
        if (length == null || length <= 0)
            throw new InvalidRequestException("Length is required");
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", actors=" + actors +
                ", genres=" + genres +
                ", minAge=" + minAge +
                ", length=" + length +
                '}';
    }
}

package pl.com.bottega.cinema.api;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Actor;
import pl.com.bottega.cinema.domain.Genre;
import pl.com.bottega.cinema.domain.Show;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String title;
    private String description;
    private Collection<Actor> actors;
    private Collection<Genre> genres;
    private Integer minAge;
    private Integer length;

    public void setActors(Collection<String> actors) {
        this.actors = actors.stream().map(Actor::new).collect(Collectors.toList());
    }

    public void setGenres(Collection<String> genres) {
        this.genres = genres.stream().map(Genre::new).collect(Collectors.toList());
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
}

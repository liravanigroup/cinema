package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Actor;
import pl.com.bottega.cinema.domain.Genre;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Admin on 15.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private String title;
    private String description;
    private Collection<Actor> actors;
    private Collection<Genre> genres;
    private Integer minAge;
    private Integer length;
    private Collection<ShowData> shows;

    public void setActors(Collection<String> actors) {
        this.actors = actors.stream().map(Actor::new).collect(Collectors.toList());
    }

    public void setGenres(Collection<String> genres) {
        this.genres = genres.stream().map(Genre::new).collect(Collectors.toList());
    }
}
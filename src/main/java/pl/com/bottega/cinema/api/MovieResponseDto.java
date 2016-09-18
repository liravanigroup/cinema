package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.Show;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 15.09.2016.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieResponseDto {
    private String title;
    private String description;
    private Collection<String> actors;
    private Collection<String> genres;
    private Integer minAge;
    private Integer length;
    private Collection<ShowDto> shows;

    public MovieResponseDto(Movie movie) {
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.actors = movie.getActors();
        this.genres = movie.getGenres();
        this.minAge = movie.getMinAge();
        this.length = movie.getLength();
        this.shows = getShowDto(movie.getShows());
    }

    private List<ShowDto> getShowDto(Collection<Show> show) {
        return show.stream().map(ShowDto::new).collect(Collectors.toList());
    }

}
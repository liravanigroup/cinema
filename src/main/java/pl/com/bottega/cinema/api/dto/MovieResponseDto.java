package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {

    private String title;
    private String description;
    private Collection<String> actors;
    private Collection<String> genres;
    private Integer minAge;
    private Integer length;
    private Collection<ShowDto> shows;

    public MovieResponseDto(Movie m) {
        this(m.getTitle(), m.getDescription(), m.getActors(), m.getGenres(), m.getMinAge(), m.getLength(), m.getShowsDto());
    }

}
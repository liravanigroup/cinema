package pl.com.bottega.cinema.api.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.Show;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieShortResponseDto {
    private Long id;
    private String title;

    public MovieShortResponseDto(Show show) {
        Movie movie = show.getMovie();
        this.id = movie.getId();
        this.title = movie.getTitle();
    }
}


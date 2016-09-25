package pl.com.bottega.cinema.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.response.dto.MovieResponseDto;
import pl.com.bottega.cinema.domain.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Admin on 14.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class ListMoviesResponse {

    private Collection<MovieResponseDto> movies;

    public ListMoviesResponse(Collection<Movie> movies) {
        this.movies = movies.stream().map(MovieResponseDto::new).collect(Collectors.toList());
    }
}

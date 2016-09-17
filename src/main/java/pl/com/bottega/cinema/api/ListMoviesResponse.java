package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.api.MovieResponseDto;

import java.util.Collection;

/**
 * Created by Admin on 14.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ListMoviesResponse {
    private Collection<MovieResponseDto> movies;
}

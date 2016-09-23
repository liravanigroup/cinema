package pl.com.bottega.cinema.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.MovieResponseDto;

import java.util.Collection;

/**
 * Created by Admin on 14.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListMoviesResponse {
    private Collection<MovieResponseDto> movies;
}

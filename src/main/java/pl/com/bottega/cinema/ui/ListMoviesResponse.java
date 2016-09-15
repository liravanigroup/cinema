package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

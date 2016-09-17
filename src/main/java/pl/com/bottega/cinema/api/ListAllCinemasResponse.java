package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.api.CinemaDto;

import java.util.Collection;

/**
 * Created by anna on 04.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ListAllCinemasResponse {
    private Collection<CinemaDto> cinemas;
}

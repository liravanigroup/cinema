package pl.com.bottega.cinema.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.CinemaDto;

import java.util.Collection;

/**
 * Created by anna on 04.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListAllCinemasResponse {
    private Collection<CinemaDto> cinemas;
}

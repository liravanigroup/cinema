package pl.com.bottega.cinema.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.CinemaDto;
import pl.com.bottega.cinema.domain.Cinema;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anna on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class ListAllCinemasResponse {

    private Collection<CinemaDto> cinemas;

    public ListAllCinemasResponse(List<Cinema> cinemas) {
        this.cinemas = cinemas.stream().map(CinemaDto::new).collect(Collectors.toList());
    }
}

package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
public class CreateCinemaRequest {

    private CinemaDto cinema;

    public void validate() {
        cinema.validate();
    }
}

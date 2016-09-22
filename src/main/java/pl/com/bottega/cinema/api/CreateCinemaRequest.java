package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCinemaRequest {

    private CinemaDto cinema;

    public void validate() {
        cinema.validate();
    }
}

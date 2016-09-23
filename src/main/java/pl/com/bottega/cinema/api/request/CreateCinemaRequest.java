package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.CinemaDto;

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

    public String getName() {
        return cinema.getName();
    }

    public String getCity() {
        return cinema.getCity();
    }
}

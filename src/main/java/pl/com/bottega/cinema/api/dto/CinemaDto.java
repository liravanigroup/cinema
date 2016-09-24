package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Cinema;

import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto {

    private Long id;
    private String name, city;

    public CinemaDto(Cinema cinema) {
        this(cinema.getName(), cinema.getCity());
        this.id = cinema.getId();
    }

    public CinemaDto(String name, String city) {
        this(null, name, city);
    }

    public void validate() {
        stringValidate(name, "Cinema name is required");
        stringValidate(city, "City name is required");
    }
}

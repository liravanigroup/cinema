package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Cinema;

import static pl.com.bottega.cinema.domain.Validator.stringValidate;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class CinemaDto {

    private Long id;
    private String name, city;

    public CinemaDto(Cinema cinema) {
        this(cinema.getName(), cinema.getCity());
        this.id = cinema.getId();
    }

    public CinemaDto(String name, String city) {
        this.name = name;
        this.city = city;
    }

    void validate() {
        stringValidate(name, "Cinema name is required");
        stringValidate(city, "City name is required");
    }
}

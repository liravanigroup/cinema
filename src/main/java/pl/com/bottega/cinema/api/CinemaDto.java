package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Cinema;

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
        this.id = cinema.getId();
        this.city = cinema.getCity();
        this.name = cinema.getName();
    }

    public CinemaDto(String name, String city) {
        this.name = name;
        this.city = city;
    }

    void validate() {
        if (name == null || name.length() == 0)
            throw new InvalidRequestException("Cinema name is required");
        if (name.length() < 4)
            throw new InvalidRequestException("Cinema name should be longer then 5 symbols");
        if (city == null || city.length() == 0)
            throw new InvalidRequestException("City name is required");
        if (city.length() < 4)
            throw new InvalidRequestException("City name should be longer then 5 symbols");
    }
}

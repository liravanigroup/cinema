package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
public class CinemaDto {

    private Long id;
    private String name, city;

    public CinemaDto() {
    }

    public CinemaDto(Cinema c) {
        this.id = c.getId();
        this.city = c.getCity();
        this.name = c.getName();
    }

    public CinemaDto(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void validate() {
        if (name == null || name.length() == 0)
            throw new InvalidRequestException("Cinema name is required");
        if (city == null || city.length() == 0)
            throw  new InvalidRequestException("City name is required");
    }
}

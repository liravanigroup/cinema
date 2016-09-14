package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Cinema;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CinemaDto {

    private Long id;
    private String name, city;

    public CinemaDto(Cinema c) {
        this.id = c.getId();
        this.city = c.getCity();
        this.name = c.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void validate() {
        if (name == null || name.length() == 0)
            throw new InvalidRequestException("Cinema name is required");
        if (city == null || city.length() == 0)
            throw  new InvalidRequestException("City name is required");
    }
}

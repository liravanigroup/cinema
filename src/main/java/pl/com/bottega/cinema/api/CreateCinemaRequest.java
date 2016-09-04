package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.CinemaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateCinemaRequest {

    private String name;
    private String city;

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

    public void validate(CinemaRepository repository) throws InvalidRequestException{
        if (name == null || name.length() == 0)
            throw new InvalidRequestException("Cinema name is required!");
        if (city == null || city.length() == 0)
            throw  new InvalidRequestException("City name is required!");
    }
}
package pl.com.bottega.cinema.api;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CinemaDto {

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

    public void validate() throws InvalidRequestException {
        if (name == null || city.length() == 0)
            throw new InvalidRequestException("Cinema name is required!");
        if (name == null || city.length() == 0)
            throw  new InvalidRequestException("City name is required!");
    }

    @Override
    public String toString() {
        return "CinemaDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

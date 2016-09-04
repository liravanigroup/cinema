package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.ui.ListAllCinemasResponse;

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
}

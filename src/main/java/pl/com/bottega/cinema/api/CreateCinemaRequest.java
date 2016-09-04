package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.CinemaRepository;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateCinemaRequest {

    String name;
    String city;

    public void validate(CinemaRepository repository){

    }
}

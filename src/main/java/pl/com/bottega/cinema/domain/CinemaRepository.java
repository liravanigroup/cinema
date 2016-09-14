package pl.com.bottega.cinema.domain;

import pl.com.bottega.cinema.api.CreateCinemaRequest;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public interface CinemaRepository {

    void save(Cinema cinema);

    Cinema load(CreateCinemaRequest request);
}

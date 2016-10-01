package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.Cinema;

import java.util.List;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public interface CinemaCatalog {
    List<Cinema> listAll();
}

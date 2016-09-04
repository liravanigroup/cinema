package pl.com.bottega.cinema.domain;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public interface CinemaRepository {

    void save(Cinema cinema);

    void load(String name, String cinema);
}

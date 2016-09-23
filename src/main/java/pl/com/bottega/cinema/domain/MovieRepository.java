package pl.com.bottega.cinema.domain;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public interface MovieRepository {

    void save(Movie movie);

    Movie load(Long movieId);

    Movie load(String title, String description);
}

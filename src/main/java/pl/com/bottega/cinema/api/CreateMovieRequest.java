package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
public class CreateMovieRequest {

    private MovieDto movie;

    public void validate() {
        movie.validate();
    }

}
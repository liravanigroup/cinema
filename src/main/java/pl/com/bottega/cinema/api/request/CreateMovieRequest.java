package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.MovieDto;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {

    private MovieDto movie;

    public void validate() {
        movie.validate();
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public String getDescription() {
        return movie.getDescription();
    }
}
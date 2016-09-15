package pl.com.bottega.cinema.api;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.Movie;

@Component
public class MovieFactory {

    public Movie createMovie(CreateMovieRequest request) {
        MovieDto movie = request.getMovie();
        return new Movie(movie.getTitle(), movie.getDescription(), movie.getMinAge(), movie.getActors(),
                movie.getGenres(), movie.getLength());
    }
}

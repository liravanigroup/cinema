package pl.com.bottega.cinema.api;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.Movie;

@Component
public class MovieFactory {

    public Movie createMovie(CreateMovieRequest request) {
        return new Movie(request.getTitle(), request.getDescription(), request.getMinAge(), request.getActors(),
                request.getGenres(), request.getLength());
    }
}

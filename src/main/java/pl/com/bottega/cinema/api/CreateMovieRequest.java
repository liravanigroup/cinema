package pl.com.bottega.cinema.api;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateMovieRequest {

    private MovieDto movie;

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public void validate() {
        movie.validate();
    }


    @Override
    public String toString() {
        return movie.toString();
    }
}

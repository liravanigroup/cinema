package pl.com.bottega.cinema.api;

/**
 * Created by anna on 06.09.2016.
 */
public class InvalidRequestExceptionWhenCinemaAlreadyExist extends Throwable {

    public InvalidRequestExceptionWhenCinemaAlreadyExist() {
        super("Cinema already exist");
    }
}

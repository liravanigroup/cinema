package pl.com.bottega.cinema.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cinema cinema;
    @ManyToOne(cascade = CascadeType.ALL)
    private Movie Movie;

    private LocalDateTime date;

    public Show() {
    }

    public Show(Cinema Cinema, Movie Movie, LocalDateTime date) {
        this.cinema = Cinema;
        this.Movie = Movie;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema Cinema) {
        this.cinema = Cinema;
    }

    public Movie getMovie() {
        return Movie;
    }

    public void setMovie(Movie Movie) {
        this.Movie = Movie;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

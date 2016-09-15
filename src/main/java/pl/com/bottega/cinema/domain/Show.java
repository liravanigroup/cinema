package pl.com.bottega.cinema.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Movie movie;

    private LocalDateTime date;

    public Show() {
    }

    public Show(Cinema cinema, Movie Movie, LocalDateTime date) {
        this.cinema = cinema;
        this.movie = Movie;
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

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie Movie) {
        this.movie = Movie;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

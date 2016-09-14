package pl.com.bottega.cinema.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Entity
public class Show {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Cinema cinema;
    @ManyToOne
    private Movie movie;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    public Show() {}

    public Show(Cinema cinema, Movie movie, Date date) {
        this.cinema = cinema;
        this.movie = movie;
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

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

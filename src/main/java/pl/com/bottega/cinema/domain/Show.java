package pl.com.bottega.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = ALL)
    private Cinema cinema;
    @ManyToOne(cascade = ALL)
    private Movie movie;
    private LocalDateTime date;

    public Show(Cinema cinema, Movie movie, LocalDateTime date){
        this.cinema = cinema;
        this.movie = movie;
        this.date = date;
    }
}

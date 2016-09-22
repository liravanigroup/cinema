package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Entity
public class Show implements Serializable {

    private static final long serialVersionUID = -3411664175982363078L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = ALL)
    private Cinema cinema;

    @ManyToOne(cascade = ALL)
    private Movie movie;

    private LocalDate date;
    private LocalTime time;

    public Show(Cinema cinema, Movie movie, LocalDateTime dateOfShow){
        this.cinema = cinema;
        this.movie = movie;
        this.date = dateOfShow.toLocalDate();
        this.time = dateOfShow.toLocalTime();
    }
}

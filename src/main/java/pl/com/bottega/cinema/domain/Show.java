package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Entity
@NamedQueries({
        @NamedQuery(name = "Show.findShowsByShowParams",
                query = "SELECT s FROM Show s " +
                        "WHERE s.cinema.id = :cinemaId AND s.movie.id = :movieId " +
                        "AND s.date = :date AND s.time = :time")
})
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

    public Show(Cinema cinema, Movie movie, LocalDate dateOfShow, LocalTime timeOfShow) {
        this(null, cinema, movie, dateOfShow, timeOfShow);
    }

    public Show(Cinema cinema, Movie movie, LocalDateTime date) {
        this(cinema, movie, date.toLocalDate(), date.toLocalTime());
    }
}

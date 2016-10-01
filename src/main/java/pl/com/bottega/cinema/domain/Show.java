package pl.com.bottega.cinema.domain;

import com.google.common.base.MoreObjects;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Show.findShowsByShowDate",
                query = "SELECT s FROM Show s " +
                        "WHERE s.cinema.id=:cinemaId " +
                        "AND s.movie.id=:movieId " +
                        "AND s.date=:date " +
                        "AND s.time=:time")
})
@Entity
public class Show implements Serializable {

    private static final long serialVersionUID = -3411664175982363078L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cinema cinema;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    private Movie movie;

    private LocalDate date;
    private LocalTime time;

    @OneToMany(cascade = ALL, mappedBy = "show", fetch = EAGER)
    private Set<Reservation> reservations;

    public Show(Cinema cinema, Movie movie, LocalDate dateOfShow, LocalTime timeOfShow) {
        this(null, cinema, movie, dateOfShow, timeOfShow, null);
    }

    public Show(Cinema cinema, Movie movie, LocalDateTime date) {
        this(cinema, movie, date.toLocalDate(), date.toLocalTime());
    }
}

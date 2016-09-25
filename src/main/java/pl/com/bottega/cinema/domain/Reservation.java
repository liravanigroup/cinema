package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.dto.CustomerDto;
import pl.com.bottega.cinema.api.dto.TicketDto;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by anna on 25.09.2016.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Reservation.findByTitleAndDescription",
                query = "SELECT r FROM Reservation r WHERE m.title=:title AND m.description=:descr"),
        @NamedQuery(name = "Movie.findByCinemaIdAndDate",
                query = "SELECT DISTINCT m FROM Movie m " +
                        "JOIN FETCH m.shows s JOIN FETCH s.cinema c " +
                        "JOIN FETCH m.actors JOIN FETCH m.genres " +
                        "WHERE c.id = :cinemaId AND s.date = :date " +
                        "ORDER BY m.title")
})
public class Reservation implements Serializable {

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation", fetch = FetchType.EAGER)
    private Set<TicketOrder> ticekts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation", fetch = FetchType.EAGER)
    private Set<Seat> seats;

    @Embedded
    private Customer customer;


    public Reservation(CreateReservationRequest request) {

    }
}

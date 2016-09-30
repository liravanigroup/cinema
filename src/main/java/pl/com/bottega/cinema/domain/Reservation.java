package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by anna on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "Reservation.findByShowIdAndCustomer",
                query = "SELECT r FROM Reservation r " +
                        "WHERE r.show.id=:showId " +
                        "AND r.customer.firstName=:firstName " +
                        "AND r.customer.lastName=:lastName"),
        @NamedQuery(name = "Reservation.findByCustomerLastNameAndStatus",
                query = "SELECT r FROM Reservation r " +
                        "WHERE r.customer.lastName=:lastName " +
                        "AND r.status=:status")
})
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = -4979533539276386449L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany(cascade = ALL)
    private Set<TicketOrder> tickets;

    @OneToMany(cascade = ALL)
    private Set<Seat> seats;

    @ManyToOne(cascade = ALL)
    private Customer customer;

    @ManyToOne(cascade = ALL)
    private Show show;

    private String status;
    private BigDecimal totalPrice;

    public Reservation(Show show, Set<TicketOrder> tickets, Set<Seat> seats, Customer customer, BigDecimal totalPrice) {
        this(null, tickets, seats, customer, show, "pending", totalPrice);
    }
}

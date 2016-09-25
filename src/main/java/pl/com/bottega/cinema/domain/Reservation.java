package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation", fetch = FetchType.EAGER)
    private Set<TicketOrder> ticekts;

    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation", fetch = FetchType.EAGER)
    private Set<Seat> seats;

    @Embedded
    private Customer customer;

    @ManyToOne
    private Show show;

    private BigDecimal totalPrice;

    public Reservation(Set<TicketOrder> ticekts, Set<Seat> seats, Customer customer, BigDecimal totalPrice) {
        this(null, ticekts, "pending", seats, customer, null, totalPrice);
    }
}

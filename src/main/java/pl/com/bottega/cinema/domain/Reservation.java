package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static pl.com.bottega.cinema.domain.ReservationStatus.PENDING;

/**
 * Created by anna on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@ToString
@NamedQueries({
        @NamedQuery(name = "Reservation.findByCustomerLastNameAndStatus",
                query = "SELECT DISTINCT r FROM Reservation r " +
                        "WHERE r.customer.lastName=:lastName AND r.status=:status"),
        @NamedQuery(name = "Reservation.loadReservationByReservationId",
                query = "SELECT r FROM Reservation r WHERE r.id = :id")
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

    @OneToMany(cascade = ALL)
    private Set<Payment> payments;

    @Enumerated(value = STRING)
    private ReservationStatus status;

    private BigDecimal totalPrice;

    public Reservation(Show show, Set<TicketOrder> tickets, Set<Seat> seats, Customer customer, BigDecimal totalPrice) {
        this(null, tickets, seats, customer, show, null, PENDING, totalPrice);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
}

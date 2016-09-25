package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.dto.CustomerDto;
import pl.com.bottega.cinema.domain.TicketOrder;
import pl.com.bottega.cinema.api.request.CreateReservationRequest;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by anna on 25.09.2016.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Reservation.findByShowIdAndCustomer",
                query = "")
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

    @ManyToOne
    private Show show;


    public Reservation(CreateReservationRequest request) {

    }
}

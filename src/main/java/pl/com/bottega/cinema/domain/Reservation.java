package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.Customer;
import pl.com.bottega.cinema.api.dto.CustomerDto;
import pl.com.bottega.cinema.api.dto.TicketDto;
import pl.com.bottega.cinema.api.request.SeatDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by anna on 25.09.2016.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Reservation implements Serializable {

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    private Collection<TicketOrder> ticekts;

    private Collection<SeatDto> seats;
    @OneToMany()
    private CustomerDto customer;


}

package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.CustomerDto;
import pl.com.bottega.cinema.domain.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable{

    private static final long serialVersionUID = -6979533539276386449L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(cascade = ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    public Customer(CustomerDto customer) {
        this(null, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), null);
    }
}

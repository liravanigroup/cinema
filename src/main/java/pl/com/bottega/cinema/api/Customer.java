package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.CustomerDto;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Customer implements Serializable{

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customer(CustomerDto customer) {
        this(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone());
    }
}

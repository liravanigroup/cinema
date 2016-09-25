package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.CustomerDto;

import javax.persistence.Embeddable;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customer(CustomerDto customer) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
    }
}

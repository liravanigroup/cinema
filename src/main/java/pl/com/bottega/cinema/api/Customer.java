package pl.com.bottega.cinema.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Created by anna on 24.09.2016.
 */
@Getter
@Setter
@Embeddable
public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

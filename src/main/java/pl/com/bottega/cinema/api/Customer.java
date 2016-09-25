package pl.com.bottega.cinema.api;

import javax.persistence.Embeddable;

/**
 * Created by anna on 24.09.2016.
 */
@Embeddable
public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

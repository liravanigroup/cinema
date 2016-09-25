package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.util.regex.Pattern;

import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;
import static pl.com.bottega.cinema.domain.validators.StringValidator.validateEmail;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public void validate() {
        stringValidate(firstName, "First name is required");
        stringValidate(lastName, "Last name is required");
        validateEmail(email.trim(), "Email is incorrect");
        stringValidate(phone, "Pnone is required");
    }
}




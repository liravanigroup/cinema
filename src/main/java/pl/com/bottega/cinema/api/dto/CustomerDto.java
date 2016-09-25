package pl.com.bottega.cinema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
}

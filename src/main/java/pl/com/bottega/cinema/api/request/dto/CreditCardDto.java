package pl.com.bottega.cinema.api.request.dto;

import lombok.Getter;
import lombok.Setter;
import static pl.com.bottega.cinema.domain.validators.CardValidator.*;
import static pl.com.bottega.cinema.domain.validators.ObjectValidator.notNullValidate;

/**
 * Created by Admin on 01.10.2016.
 */
@Getter
@Setter
public class CreditCardDto {
    private Long number;
    private Byte expirationMonth;
    private Short expirationYear;
    private String cvc;

    public void validate() {
        notNullValidate(number, "Number is required");
        notNullValidate(expirationYear, "Expiration year is required");
        notNullValidate(expirationMonth, "Expiration month is required");
        notNullValidate(cvc, "CVC is required");
        cardNumberValidate(number, "Check your credit card number once more");
        cardExpYearValidate(expirationYear, "Wrong expiration year of credit card");
        cardExpMonthValidate(expirationMonth, "Wrong expiration month of credit card");
        cardCvcValidate(cvc, "Check the CVC-code of your credit card");
    }
}

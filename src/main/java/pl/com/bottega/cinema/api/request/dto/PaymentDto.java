package pl.com.bottega.cinema.api.request.dto;

import lombok.Getter;
import lombok.Setter;

import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;
import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Getter
@Setter
public class PaymentDto {

    private String type;
    private Long cashierId;
    private CreditCardDto creditCard;

    public void validate() {
        stringValidate(type, "Type is required");
        if (cashierId == null)
            creditCard.validate();
        else
            entityIdValidate(cashierId, "Cashier id is incorrect");
    }

    public Short getYear() {
        return creditCard.getExpirationYear();
    }

    public Byte getMonth() {
        return creditCard.getExpirationMonth();
    }

    public String getCvc() {
        return creditCard.getCvc();
    }

    public String getNumber() {
        return creditCard.getNumber();
    }
}

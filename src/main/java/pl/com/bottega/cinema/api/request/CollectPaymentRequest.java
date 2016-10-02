package pl.com.bottega.cinema.api.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.com.bottega.cinema.api.request.dto.PaymentDto;

import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

/**
 * Created by Admin on 01.10.2016.
 */
@Getter
@Setter
@ToString
public class CollectPaymentRequest {

    private Long reservationNumber;
    private PaymentDto payment;

    public void validate(){
        entityIdValidate(reservationNumber, "Reservation number is incorrect");
        payment.validate();
    }

    public Short getYear() {
        return payment.getYear();
    }

    public String getCardNumber() {
        return payment.getNumber();
    }

    public Byte getMonth() {
        return payment.getMonth();
    }

    public String getCvc() {
        return payment.getCvc();
    }
}

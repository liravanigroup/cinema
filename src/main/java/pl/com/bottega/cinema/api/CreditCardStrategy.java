package pl.com.bottega.cinema.api;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.request.dto.PaymentDto;
import pl.com.bottega.cinema.domain.Payment;
import pl.com.bottega.cinema.domain.PaymentType;
import pl.com.bottega.cinema.domain.Reservation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Service
public class CreditCardStrategy implements PaymentStrategy {

    private static final String SECURITY_KEY = "sk_test_4Q3wzpW9rdtJOREOVe91ut9h";
    private static final String CURRENCY = "usd";
    private static final RequestOptions REQUEST_OPTIONS = (new RequestOptions.RequestOptionsBuilder()).setApiKey(SECURITY_KEY).build();

    @Override
    public Payment pay(PaymentDto payment, Reservation reservation) {
        try {
            Charge charge = Charge.create(getChargeMap(payment, reservation), REQUEST_OPTIONS);
            return new Payment(PaymentType.CREDIT_CARD, charge, reservation);
        } catch (StripeException ex) {
            return new Payment(PaymentType.CREDIT_CARD, CURRENCY, reservation);
        }
    }

    private Map<String, Object> getCardMap(PaymentDto payment) {
        Map<String, Object> cardMap = new HashMap<>();
        cardMap.put("number", payment.getNumber());
        cardMap.put("exp_month", payment.getMonth());
        cardMap.put("exp_year", payment.getYear());
        cardMap.put("cvc", payment.getCvc());
        return cardMap;
    }

    private Map<String, Object> getChargeMap(PaymentDto payment, Reservation reservation) {
        Map<String, Object> chargeMap = new HashMap<>();
        chargeMap.put("amount", getCentsValue(reservation.getTotalPrice()));
        chargeMap.put("currency", CURRENCY);
        chargeMap.put("description", getDescription(reservation));
        chargeMap.put("card", getCardMap(payment));
        return chargeMap;
    }

    private int getCentsValue(BigDecimal amount) {
        return (int) (amount.doubleValue() * 100);
    }

    private String getDescription(Reservation reservation) {
        return String.format("Payment for reservation number %s", reservation.getId());
    }
}

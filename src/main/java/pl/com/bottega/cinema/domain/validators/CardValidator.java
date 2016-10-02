package pl.com.bottega.cinema.domain.validators;

import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 01.10.2016.
 */
@NoArgsConstructor(access = PRIVATE)
public class CardValidator {

    private static final int MAX_YEAR_COUNT_OF_CARD_EXP = 5;

    public static void cardNumberValidate(Long cardNumber, String message) {
        if (!Pattern.matches("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$", cardNumber.toString()))
            throw new InvalidRequestException(message);
    }

    public static void cardExpYearValidate(Short year, String message) {
        int currentYear = LocalDate.now().getYear();
        if (currentYear > year || (year - currentYear) > MAX_YEAR_COUNT_OF_CARD_EXP)
            throw new InvalidRequestException(message);
    }

    public static void cardExpMonthValidate(Byte month, String message) {
        if (month < 1 || month > 12)
            throw new InvalidRequestException(message);
    }

    public static void cardCvcValidate(String cvc, String message) {
        try {
            int cvcInt = Integer.parseInt(cvc);
        } catch (NumberFormatException ex) {
            throw new InvalidRequestException("Check your credit card CVC");
        }
        if (cvc.length() != 3)
            throw new InvalidRequestException(message);
    }
}

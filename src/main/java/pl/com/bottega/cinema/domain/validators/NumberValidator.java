package pl.com.bottega.cinema.domain.validators;

import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@NoArgsConstructor(access = PRIVATE)
public class NumberValidator {

    private static final Integer MAX_MOVIE_LENGTH = 240;
    private static final Integer MAX_AGE = 100;
    private static final Integer MIN_VALUE = 0;

    public static void entityIdValidate(Long id, String message) {
        if (isNull(id) || isNegative(Math.toIntExact(id)))
            throw new InvalidRequestException(message);
    }

    private static boolean isLengthTooBig(Integer length) {
        return length > MAX_MOVIE_LENGTH;
    }

    public static void movieLengthValidate(Integer length, String message) {
        if (isNull(length) || isNegative(length) || isLengthTooBig(length))
            throw new InvalidRequestException(message);
    }

    private static boolean isNegative(Integer number) {
        return number < MIN_VALUE;
    }

    private static boolean isTooBig(Integer number) {
        return number > MAX_AGE;
    }

    public static void minAgeValidate(Integer age, String message) {
        if (isNull(age) || isNegative(age) || isTooBig(age))
            throw new InvalidRequestException(message);
    }

    public static void priceValidation(BigDecimal price, String message) {
        if (isNull(price) || price.signum() < 0)
            throw new InvalidRequestException(message);
    }

}
package pl.com.bottega.cinema.domain.validators;

import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@NoArgsConstructor(access = PRIVATE)
public class StringValidator {

    public static void stringValidate(final String name, String message) {
        if (stringIsCorrect(name))
            throw new InvalidRequestException(message);
    }

    public static void validateEmail(String email, String message) {
        if(!Pattern.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}",email))
            throw new InvalidRequestException(message);
    }

    private static boolean stringIsCorrect(String value) {
        return isNull(value) || value.trim().isEmpty();
    }

}

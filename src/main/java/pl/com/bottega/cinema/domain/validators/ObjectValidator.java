package pl.com.bottega.cinema.domain.validators;

import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
@NoArgsConstructor(access = PRIVATE)
public class ObjectValidator {

    public static void existingValidation(Object obj, String message){
        if(isNotNull(obj))
            throw new InvalidRequestException(message);
    }

    private static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static void notNullValidate(Object value, String message) {
        if(isNull(value))
            throw new InvalidRequestException(message);
    }
}

package pl.com.bottega.cinema.domain.validators;

import pl.com.bottega.cinema.api.InvalidRequestException;

import java.time.LocalDate;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
public class DateValidator {

    private DateValidator() {
    }

    public static void futureDateValidate(LocalDate dateOfFuture, String message){
        LocalDate now = LocalDate.now();
        if(!dateOfFuture.equals(now) || now.isAfter(dateOfFuture))
            throwSystemException(message);
    }

    private static void throwSystemException(String message) {
        throw new InvalidRequestException(message);
    }

}

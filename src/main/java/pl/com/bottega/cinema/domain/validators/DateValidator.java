package pl.com.bottega.cinema.domain.validators;

import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static pl.com.bottega.cinema.domain.validators.ObjectValidator.notNullValidate;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@NoArgsConstructor(access = PRIVATE)
public class DateValidator {

    public static void futureDateValidate(LocalDate dateOfFuture, String message){
        LocalDate now = LocalDate.now();
        notNullValidate(dateOfFuture, "Date is required");
        if(dateOfFuture.isBefore(now))
            throw new InvalidRequestException(message);
    }

    public static void dateSequenceValidate(LocalDateTime fromDate, LocalDateTime untilDate, String message) {
        if(fromDate.isAfter(untilDate))
            throw new InvalidRequestException(message);
    }
}

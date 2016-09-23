package pl.com.bottega.cinema.domain.validators;

import pl.com.bottega.cinema.api.InvalidRequestException;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
public class Validator {

    private static final int MAX_MOVIE_LENGTH = 240;
    private static Integer MAX_AGE = 100;
    private static Integer MIN_VALUE = 0;

    private Validator(){};

    public static void stringValidate(final String name, String message) {
        if (stringIsCorrect(name))
            throwSystemException(message);
    }

    public static void existingValidation(final Object obj, String message){
        if(isNotNull(obj))
            throwSystemException(message);
    }

    private static boolean isNotNull(final Object obj) {
        return obj != null;
    }

    private static boolean stringIsCorrect(String value) {
        return isNull(value) || getSymbolsCount(value) == 0;
    }

    public static void notNullValidate(Object value, String message) {
        if(isNull(value))
            throwSystemException(message);
    }

    private static boolean isNull(Object value) {
        return null == value;
    }

    private static int getSymbolsCount(String value) {
        return value.trim().length();
    }

    private static boolean isNegative(Integer number){
        return number < MIN_VALUE;
    }

    private static boolean isTooBig(Integer number){
        return number > MAX_AGE;
    }

    public static void minAgeValidate(Integer age, String message){
        if (isNull(age) || isNegative(age) || isTooBig(age))
            throwSystemException(message);
    }

    public static void movieLengthValidate(Integer length, String message){
        if(isNull(length) || isNegative(length) || isLengthTooBig(length))
            throwSystemException(message);
    }

    private static boolean isLengthTooBig(Integer length) {
        return length > MAX_MOVIE_LENGTH;
    }

    private static boolean isEmptyCollection(Collection collection){
        return collection.isEmpty();
    }

    public static void collectionValidate(Collection collection, String message){
        if (isNull(collection) || isEmptyCollection(collection))
            throwSystemException(message);
    }

    private static void throwSystemException(String message) {
        throw new InvalidRequestException(message);
    }

    public static void entityIdValidate(Long id, String message){
        if(isNull(id) || isNegative(Math.toIntExact(id)))
            throwSystemException(message);
    }

    public static void dateSequenceValidate(LocalDateTime fromDate, LocalDateTime untilDate, String message) {
        if(fromDate.isAfter(untilDate))
            throwSystemException(message);
    }

    public static void dateValidate(LocalDateTime date, String message) {
        if(isNull(date))
            throwSystemException(message);
    }
}

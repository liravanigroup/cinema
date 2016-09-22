package pl.com.bottega.cinema.domain;

import pl.com.bottega.cinema.api.InvalidRequestException;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
public class Validator {

    private Validator(){};

    public static void stringValidate(String name, String message) {
        if (stringIsCorrect(name))
            throw new InvalidRequestException(message);
    }

    private static boolean stringIsCorrect(String value) {
        return isNull(value) || getSymbolsCount(value) == 0;
    }

    private static boolean isNull(String value) {
        return null == value;
    }

    private static int getSymbolsCount(String value) {
        return value.trim().length();
    }
}

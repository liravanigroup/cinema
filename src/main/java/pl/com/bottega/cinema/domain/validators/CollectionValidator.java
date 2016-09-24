package pl.com.bottega.cinema.domain.validators;

import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Sergej Povzaniuk on 24.09.2016.
 */
@NoArgsConstructor(access = PRIVATE)
public class CollectionValidator {

    public static void collectionValidate(Collection collection, String message) {
        if (isNull(collection) || collection.isEmpty())
            throw new InvalidRequestException(message);
    }

    public static void containsValuesValidate(Collection<String> prices, String message, String... values) {
        Arrays.stream(values).forEach(s -> {
            if (!prices.contains(s))
                throw new InvalidRequestException(message);
        });
    }
}

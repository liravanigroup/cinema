package pl.com.bottega.cinema.domain.validators;

import com.google.common.collect.HashMultiset;
import lombok.NoArgsConstructor;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.api.request.dto.TicketDto;

import java.util.Arrays;
import java.util.Collection;

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

    public static void preventDuplicationTicketsType(Collection<TicketDto> tickets,
                                                     String messageIfDuplicate,
                                                     String messageIfInvalidType) {
        for (TicketDto ticket : tickets) {
            if (getCountDuplicatedTickets(ticket, tickets, messageIfInvalidType) > 1)
                throw new InvalidRequestException(messageIfDuplicate);
        }
    }

    private static int getCountDuplicatedTickets(TicketDto ticket, Collection<TicketDto> tickets, String messageIfInvalidType) {
        if (!tickets.contains(ticket))
            throw new InvalidRequestException(messageIfInvalidType);
        return HashMultiset.create(tickets).count(ticket);
    }
}

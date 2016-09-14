package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.Show;

import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */

@Component
public class ShowsFactory {
    public Collection<Show> createShow(CreateShowsRequest request) {
        return null;
    }
}

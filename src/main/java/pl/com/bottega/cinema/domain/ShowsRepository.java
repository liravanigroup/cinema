package pl.com.bottega.cinema.domain;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

public interface ShowsRepository {
    void save(Collection<Show> shows);

    Show load(Long cinemaId, Long movieId, LocalDate date, LocalTime time);
}

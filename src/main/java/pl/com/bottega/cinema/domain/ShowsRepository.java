package pl.com.bottega.cinema.domain;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import pl.com.bottega.cinema.ui.ShowData;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public interface ShowsRepository {

    void save(Show show);

    void save(Collection<Show> shows);

    Collection<ShowData> load(Long cinemaId, Long movieId, LocalDate date);
}

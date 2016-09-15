package pl.com.bottega.cinema.domain;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import java.util.Collection;

public interface ShowsRepository {

    void save(Show show);

    void save(Collection<Show> shows);
}

package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.ShowsDto;
import pl.com.bottega.cinema.domain.Show;
import pl.com.bottega.cinema.ui.ListShowsResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 14.09.2016.
 */
@Component
public class JPAMovieCatalog {

    @PersistenceContext
    private EntityManager entityManager;

//    public ListShowsResponse findShows(LocalDateTime date) {
//        checkNotNull(date);
//        List<Show> shows = entityManager.createQuery("SELECT s FROM Show s where s.date=:date").setParameter("date", date).getResultList();
//        List<ShowsDto> showsDtos = shows
//                .stream()
//                .map(ShowsDto::new)
//                .collect(Collectors.toList());
//        return new ListShowsResponse(showsDtos);
//    }
}

package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.CinemaDto;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.ui.ListAllCinemasResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anna on 08.09.2016.
 */
@Component
public class JPACinemaCatalog implements CinemaCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListAllCinemasResponse listAll() {
        List<Cinema> cinemas = entityManager.createQuery("FROM Cinema", Cinema.class).getResultList();
        List<CinemaDto> cinemaDtos = cinemas
                .stream()
                .map(CinemaDto::new)
                .collect(Collectors.toList());
        return new ListAllCinemasResponse(cinemaDtos);
    }

}

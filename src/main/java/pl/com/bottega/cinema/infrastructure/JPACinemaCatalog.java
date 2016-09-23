package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.dto.CinemaDto;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.api.response.ListAllCinemasResponse;

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
        List<Cinema> cinemas = entityManager.createNamedQuery("Cinema.findAll", Cinema.class).getResultList();
        return new ListAllCinemasResponse(getCinemaDtos(cinemas));
    }

    private List<CinemaDto> getCinemaDtos(List<Cinema> cinemas) {
        return cinemas.stream().map(CinemaDto::new).collect(Collectors.toList());
    }

}

package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.domain.Cinema;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by anna on 08.09.2016.
 */
@Component
public class JPACinemaCatalog implements CinemaCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cinema> listAll() {
        return entityManager.createNamedQuery("Cinema.getAll", Cinema.class).getResultList();
    }
}

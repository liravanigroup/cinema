package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Repository;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.CinemaRepository;
import pl.com.bottega.cinema.domain.Movie;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Repository
public class JPACinemaRepository implements CinemaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Cinema cinema) {
        try {
            entityManager.persist(cinema);
        }catch (EntityExistsException ex) {
            throw new InvalidRequestException("Cinema has already been created");
        }
    }

    @Override
    public Cinema load(String name, String city) {
        return null;
    }




}

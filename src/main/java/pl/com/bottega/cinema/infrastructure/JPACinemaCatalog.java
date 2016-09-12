package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.CinemaDto;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.Cinema_;
import pl.com.bottega.cinema.ui.ListAllCinemasResponse;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static com.google.common.base.Preconditions.checkNotNull;
import static pl.com.bottega.cinema.domain.Cinema_.id;

/**
 * Created by anna on 08.09.2016.
 */
@Component
public class JPACinemaCatalog implements CinemaCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListAllCinemasResponse listAll() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CinemaDto> query = builder.createQuery(CinemaDto.class);
        Root<Cinema> root = query.from(Cinema.class);
        selectCinemaDto(builder, query,root);
        Query jpaQuery = entityManager.createQuery(query);

        return new ListAllCinemasResponse(jpaQuery.getResultList());
    }

    private void selectCinemaDto(CriteriaBuilder builder, CriteriaQuery<CinemaDto> query, Root<Cinema> root){
        query.select(builder.construct(CinemaDto.class,
                root.get(Cinema_.id),
                root.get(Cinema_.name),
                root.get(Cinema_.city)
        ));
    }
}

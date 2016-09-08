package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.CinemaCatalog;
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
        checkNotNull(id);
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ListAllCinemasResponse> query = builder.createQuery(ListAllCinemasResponse.class);
        Root<Cinema> root = query.from(Cinema.class);
        query.where(builder.and(
                builder.equal(root.get(id), id))
        );
        selectListAllCinemasResponse(builder, query, root);
        return entityManager.createQuery(query).getSingleResult();
    }

    private void selectListAllCinemasResponse(CriteriaBuilder builder, CriteriaQuery<ListAllCinemasResponse> query, Root<Cinema> root) {
        query.select(builder.construct(ListAllCinemasResponse.class,
                root.get(Cinema_.id),
                root.get(Cinema_.name),
                root.get(Cinema_.city)
        ));
    }
}

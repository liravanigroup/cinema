package pl.com.bottega.cinema.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cinema.api.CinemaCatalog;
import pl.com.bottega.cinema.api.CinemaDto;
import pl.com.bottega.cinema.ui.ListAllCinemasResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by anna on 15.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
public class JPACinemaCatalogTest {

    @Autowired
    private CinemaCatalog cinemaCatalog;

    @Sql("/fixtures/cinemas.sql")
    @Test
    @Transactional
    public void shouldGetListOfCinemas() {
        //given

        //when
        ListAllCinemasResponse listAllCinemasResponse = cinemaCatalog.listAll();

        //than
        assertNotNull(listAllCinemasResponse);
    }
}

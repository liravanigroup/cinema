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
import pl.com.bottega.cinema.api.response.ListAllCinemasResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anna on 15.09.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml", "/mock-auth-context.xml"})
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
public class JPACinemaCatalogTest {

    public static final int COUNT_CINEMAS_IN_DB = 3;

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
        assertEquals(COUNT_CINEMAS_IN_DB, listAllCinemasResponse.getCinemas().size());
    }


}

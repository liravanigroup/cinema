package pl.com.bottega.cinema.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.cinema.api.request.CreateCinemaRequest;

/**
 * Created by bernard.boguszewski on 14.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CinemaCatalogTest {

    @Mock
    private AdminPanel adminPanel;

    @Mock
    CreateCinemaRequest anyCreateCinemaRequest;

    @Test
    public void shouldListAllCinemas(){
        //given
        adminPanel.createCinema(anyCreateCinemaRequest);

        //when


        //then


    }
}

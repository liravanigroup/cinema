package pl.com.bottega.cinema.api;

import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by bernard.boguszewski on 14.09.2016.
 */
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

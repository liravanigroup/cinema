package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.bottega.cinema.api.request.CreateMovieRequest;

/**
 * Created by bernard.boguszewski on 22.09.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class CreateMovieRequestTest {

    private CreateMovieRequest request;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        request = new CreateMovieRequest();
    }

    @Test
    public void shouldThrownIREWhenCinemaNameIsNull(){
        request.validate();

        thrown.expect(InvalidRequestException.class);


    }

}

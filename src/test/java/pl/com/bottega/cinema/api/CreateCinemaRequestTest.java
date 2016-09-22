package pl.com.bottega.cinema.api;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Sergej Povzaniuk on 22.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CreateCinemaRequestTest {


    @Mock
    private CinemaDto anyCinemaDto;

    private CreateCinemaRequest request;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp(){
        request = new CreateCinemaRequest(anyCinemaDto);
    }


    @Test
    public void ShouldThrownIREWhenCinemaNameIsNull() {
        //given


        //then
        thrown.expect(InvalidRequestException.class);
        thrown.expectMessage("Cinema name is required");

        //when
        request.validate();
    }

}
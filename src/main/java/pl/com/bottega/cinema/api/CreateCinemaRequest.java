package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.domain.CinemaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateCinemaRequest {

    private CinemaDto cinema;



    public CinemaDto getCinemaDto() {
        return cinema;
    }

    public void setCinemaDto(CinemaDto cinemaDto) {
        this.cinema = cinemaDto;
    }

    public void validate() throws InvalidRequestException{
        if (cinema.getName() == null || cinema.getName().length() == 0)
            throw new InvalidRequestException("Cinema name is required!");
        if (cinema.getName() == null || cinema.getName().length() == 0)
            throw  new InvalidRequestException("City name is required!");
    }


}

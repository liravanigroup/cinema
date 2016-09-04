package pl.com.bottega.cinema.api;

import pl.com.bottega.cinema.ui.ListAllCinemasResponse;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CinemaDto implements CinemaCatalog{

    private Long id;
    private String name;
    private String city;

    @Override
    public ListAllCinemasResponse listAll() {
        return null;
    }
}

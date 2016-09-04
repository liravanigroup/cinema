package pl.com.bottega.cinema.domain;

import lombok.Getter;

import java.util.List;

/**
 * Created by anna on 04.09.2016.
 */

@Getter
public class Movie {

    private String title;
    private String description;
    private int minAge;
    private List<String> actors;
    private List<String> genres;
    private int length;

}

package pl.com.bottega.cinema.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created by anna on 04.09.2016.
 */
@Entity
public class Movie implements Serializable{

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    @Lob
    private String description;
    private Integer minAge, length;

    @OneToMany(cascade = ALL)
    private Collection<Actor> actors;
    @OneToMany(cascade = ALL)
    private Collection<Genre> genres;


    public Movie() {}

    public Movie(String title, String description, Integer minAge, Collection<Actor> actors, Collection<Genre> genres, Integer length) {
        this.title = title;
        this.description = description;
        this.minAge = minAge;
        this.actors = actors;
        this.genres = genres;
        this.length = length;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }
}

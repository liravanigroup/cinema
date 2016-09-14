package pl.com.bottega.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created by anna on 04.09.2016.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Integer minAge;
    @OneToMany(cascade = ALL)
    private Collection<Actor> actors;
    @OneToMany(cascade = ALL)
    private Collection<Genre> genres;
    private Integer length;

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

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}

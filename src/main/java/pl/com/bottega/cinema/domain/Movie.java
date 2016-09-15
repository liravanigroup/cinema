package pl.com.bottega.cinema.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
public class Movie implements Serializable{

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String description;
    private Integer minAge, length;

    @OneToMany(cascade = ALL)
    private Collection<Actor> actors;
    @OneToMany(cascade = ALL)
    private Collection<Genre> genres;

    public Movie(String title, String description, Integer minAge, Collection<Actor> actors, Collection<Genre> genres, Integer length) {
        this.title = title;
        this.description = description;
        this.minAge = minAge;
        this.actors = actors;
        this.genres = genres;
        this.length = length;
    }
}

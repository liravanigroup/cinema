package pl.com.bottega.cinema.domain;

import lombok.*;
import pl.com.bottega.cinema.api.MovieDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created by anna on 04.09.2016.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"id"})
public class Movie implements Serializable {

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String description;
    private Integer minAge, length;

    @ElementCollection(fetch = EAGER)
    private Set<String> actors;
    @ElementCollection(fetch = EAGER)
    private Set<String> genres;

    @OneToMany(cascade = ALL, mappedBy = "movie", fetch = EAGER)
    private Set<Show> shows;


    @OneToMany(cascade = ALL, mappedBy = "movie", fetch = EAGER)
    private Set<TicketPrice> prices;

    public Movie(MovieDto movie) {
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.minAge = movie.getMinAge();
        this.actors = movie.getActors();
        this.genres = movie.getGenres();
        this.length = movie.getLength();
    }

    public void updatePrices(Set<TicketPrice> prices){
        this.prices = prices;
    }
}

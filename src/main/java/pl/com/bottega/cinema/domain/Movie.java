package pl.com.bottega.cinema.domain;

import lombok.*;

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

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<TicketPrice> prices;

    public Movie(String title, String description, Integer minAge, Set<String> actors, Set<String> genres, Integer length) {
        this.title = title;
        this.description = description;
        this.minAge = minAge;
        this.actors = actors;
        this.genres = genres;
        this.length = length;
    }

    public void updatePrices(Set<TicketPrice> prices){
        this.prices = prices;
    }
}

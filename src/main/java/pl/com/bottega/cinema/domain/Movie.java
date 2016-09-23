package pl.com.bottega.cinema.domain;

import com.sun.istack.internal.NotNull;
import lombok.*;
import pl.com.bottega.cinema.api.dto.MovieDto;
import pl.com.bottega.cinema.api.dto.ShowDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created by anna on 04.09.2016.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Movie implements Serializable {

    private static final long serialVersionUID = -4979533539276386479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @Lob
    @NotNull
    private String description;
    @NotNull
    private Integer minAge, length;

    @ElementCollection(fetch = EAGER)
    private Set<String> actors;
    @ElementCollection(fetch = EAGER)
    private Set<String> genres;

    @OneToMany(cascade = ALL, mappedBy = "movie", fetch = EAGER)
    private Set<Show> shows;

    @OneToMany(cascade = ALL, mappedBy = "movie", fetch = EAGER)
    private Set<TicketPrice> prices;

    public Movie(MovieDto m) {
        this(m.getTitle(), m.getDescription(), m.getMinAge(), m.getLength(), m.getActors(), m.getGenres());
    }

    public Movie(String movieTitle, String movieDescription, Integer movieMinAge, Integer movieLength, Set<String> movieActors, Set<String> movieGenres) {
        this(null, movieTitle, movieDescription, movieMinAge, movieLength, movieActors, movieGenres, null, null);
    }

    public void updatePrices(Set<TicketPrice> prices){
        this.prices = prices;
    }

    public Collection<ShowDto> getShowsDto() {
        return shows.stream().map(ShowDto::new).collect(Collectors.toList());
    }
}

package pl.com.bottega.cinema.domain;

import com.sun.istack.internal.NotNull;
import lombok.*;
import pl.com.bottega.cinema.api.dto.MovieDto;
import pl.com.bottega.cinema.api.dto.ShowDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
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
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Movie.findByTitleAndDescription",
                query = "SELECT m FROM Movie m WHERE m.title=:title AND m.description=:descr"),
        @NamedQuery(name = "Movie.findByCinemaIdAndDate",
                query = "SELECT DISTINCT m FROM Movie m " +
                        "JOIN FETCH m.shows s JOIN FETCH s.cinema c " +
                        "JOIN FETCH m.actors JOIN FETCH m.genres " +
                        "WHERE c.id = :cinemaId AND s.date = :date " +
                        "ORDER BY m.title")
})
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
    @OrderBy("time")
    private Set<Show> shows;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<Ticket> prices;


    public Movie(MovieDto m) {
        this(m.getTitle(), m.getDescription(), m.getMinAge(), m.getLength(), m.getActors(), m.getGenres());
    }

    public Movie(String movieTitle, String movieDescription, Integer movieMinAge, Integer movieLength, Set<String> movieActors, Set<String> movieGenres) {
        this(null, movieTitle, movieDescription, movieMinAge, movieLength, movieActors, movieGenres, null, null);
    }

    public void updatePrices(Set<Ticket> prices) {
        if (this.prices.isEmpty()) {
            this.prices = prices;
            return;
        }
        addUpdatedOrNewPrices(prices);
    }

    private void addUpdatedOrNewPrices(Set<Ticket> prices) {
        mark:
        for (Ticket oldTicket : this.prices) {
            if (prices.contains(oldTicket))
                continue;
            for (Ticket newTicket : prices) {
                if (oldTicket.equals(newTicket)) {
                    oldTicket.setPrice(newTicket.getPrice());
                    continue mark;
                }
                prices.add(newTicket);
            }
        }
    }

    public Collection<ShowDto> getShowsDto() {
        return shows.stream().map(ShowDto::new).collect(Collectors.toList());
    }
}

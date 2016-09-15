package pl.com.bottega.cinema.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Admin on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Entity
public class Genre implements Serializable {

    private static final long serialVersionUID = -1374601819114455678L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Genre(String genre){
        this.name = genre;
    }

    @ManyToMany
    private Collection<Movie> movies;
}

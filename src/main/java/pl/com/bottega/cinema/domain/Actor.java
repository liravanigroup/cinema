package pl.com.bottega.cinema.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

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
public class Actor implements Serializable {

    private static final long serialVersionUID = -667193605214621163L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Actor(String name){
        this.name = name;
    }

    @ManyToMany
    private Collection<Movie> movies;
}

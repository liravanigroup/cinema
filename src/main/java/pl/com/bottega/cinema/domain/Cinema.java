package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Cinema.findByNameAndCity", query = "SELECT c FROM Cinema c WHERE c.name = :name AND c.city = :city"),
        @NamedQuery(name = "Cinema.getAll", query = "SELECT c FROM Cinema c")
})
public class Cinema implements Serializable {

    private static final long serialVersionUID = -3247581407541832720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city, name;

    @OneToMany(cascade = ALL, mappedBy = "cinema", fetch = EAGER)
    private Set<Show> shows;

    public Cinema(String city, String name) {
        this(null, city, name, null);
    }

}


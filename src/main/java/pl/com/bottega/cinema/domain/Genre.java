package pl.com.bottega.cinema.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Admin on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
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
}

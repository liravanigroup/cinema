package pl.com.bottega.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Admin on 04.09.2016.
 */
@Entity
public class Actor {


    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package pl.com.bottega.cinema.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cinema implements Serializable {

    private static final long serialVersionUID = -3247581407541832720L;

    @Id
    @GeneratedValue
    private Long id;

    private String city, name;

    public Cinema(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public Cinema() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


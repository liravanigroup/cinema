package pl.com.bottega.cinema.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CINEMA", uniqueConstraints = {@UniqueConstraint(columnNames = {"CITY", "NAME"})})
public class Cinema implements Serializable {

    private static final long serialVersionUID = -3247581407541832720L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String city, name;

    public Cinema(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public Cinema() {
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

    public Long getId() {
        return id;
    }
}


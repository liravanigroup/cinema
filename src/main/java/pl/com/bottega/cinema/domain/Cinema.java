package pl.com.bottega.cinema.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cinema implements Serializable {

    private static final long serialVersionUID = -3247581407541832720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city, name;

    public Cinema(String city, String name){
        this.city = city;
        this.name = name;
    }

}


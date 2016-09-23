package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Entity
public class Cinema implements Serializable {

    private static final long serialVersionUID = -3247581407541832720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city, name;

    public Cinema(String city, String name){
        this(null, city, name);
    }

}


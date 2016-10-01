package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by anna on 25.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Entity
public class Seat implements Serializable{

    private static final long serialVersionUID = -1979533539276386449L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer row;
    private Integer seat;

    public Seat(Integer row, Integer seat) {
        this(null, row, seat);
    }
}

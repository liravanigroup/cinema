package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anna on 25.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "isFree"})
@Entity
public class Seat implements Serializable{

    private static final long serialVersionUID = -1979533539276386449L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isFree;

    private Integer row;
    private Integer seat;

    public Seat(Integer row, Integer seat, Boolean isFree) {
        this(null, isFree, row, seat);
    }
}

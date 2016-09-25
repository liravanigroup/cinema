package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    @GeneratedValue
    private Long id;

    private Boolean isFree;

    private Integer row;
    private Integer seat;

    public Seat(Integer row, Integer seat, Boolean isFree) {
        this(null, isFree, row, seat);
    }
}

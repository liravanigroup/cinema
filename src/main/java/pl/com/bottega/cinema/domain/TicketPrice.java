package pl.com.bottega.cinema.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by bernard.boguszewski on 18.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TicketPrice {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private BigDecimal price;

    @ManyToOne
    private Movie movie;

    public TicketPrice(String type, BigDecimal price, Movie movie){
        this.movie = movie;
        this.type = type;
        this.price = price;
    }




}

package pl.com.bottega.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by anna on 25.09.2016.
 */
@Entity
public class Seat {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

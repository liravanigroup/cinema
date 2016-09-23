package pl.com.bottega.cinema.domain;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    private String kind;
    private Integer count;
}

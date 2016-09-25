package pl.com.bottega.cinema.api.request.dto;/* Created by Sergej on 18.09.2016. Bottega IT Solutions */

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class TicketDto {
    private String kind;
    private Integer count;
}

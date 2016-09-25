package pl.com.bottega.cinema.api.request.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pl.com.bottega.cinema.domain.Show;

import java.time.LocalTime;

/**
 * Created by Admin on 15.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {

    private Long id;
    @JsonFormat(pattern="HH:mm")
    private LocalTime time;

    public ShowDto(Show show){
        this(show.getId(), show.getTime());
    }
}

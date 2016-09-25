package pl.com.bottega.cinema.api.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.com.bottega.cinema.domain.Show;

import java.time.LocalDateTime;

/**
 * Created by Admin on 25.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ShowResponseDto {
    private Long id;
    private LocalDateTime time;

    public ShowResponseDto(Show show){
        this.id = show.getId();
        this.time = LocalDateTime.of(show.getDate(), show.getTime());
    }
}

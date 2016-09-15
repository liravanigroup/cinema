package pl.com.bottega.cinema.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */

@Getter
@Setter
public class ShowsDto {

    private Long movieId;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm")
    private Collection<LocalDateTime> dates;
    private CalendarDto calendar;
}

package pl.com.bottega.cinema.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowsDto {

    private Long movieId;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm")
    private Set<LocalDateTime> dates;
    private CalendarDto calendar;

    void validate() {
        if(movieId == null)
            throw new InvalidRequestException("Movie id is required");
        if(movieId < 0)
            throw new InvalidRequestException("Movie id is wrong");
        if(dates.isEmpty())
            throw new InvalidRequestException("Show date is required");
    }
}

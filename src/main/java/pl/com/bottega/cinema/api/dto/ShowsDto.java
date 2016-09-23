package pl.com.bottega.cinema.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

import static pl.com.bottega.cinema.domain.Validator.collectionValidate;
import static pl.com.bottega.cinema.domain.Validator.entityIdValidate;

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

    public ShowsDto(Long movieId, Set<LocalDateTime> dates){
        this(movieId, dates, null);
    }

    public void validate() {
        entityIdValidate(movieId, "Movie id is required");
        if(calendar == null){
            collectionValidate(dates, "Show date is required");
        }else{
            calendar.validate();
        }
    }
}

package pl.com.bottega.cinema.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Admin on 10.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDto {

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime fromDate, untilDate;
    private Set<DayOfWeek> weekDays;
    @JsonFormat(pattern = "HH:mm")
    private Collection<LocalTime> hours;

    public void validate() {
        if (fromDate == null)
            throw new InvalidRequestException("First date of movie showing is required");
        if (untilDate == null)
            throw new InvalidRequestException("Last date of movie showing is required");
        if (weekDays == null || weekDays.size() <= 0)
            throw new InvalidRequestException("Week days of movie showing is required");
        if (hours == null || hours.size() <= 0)
            throw new InvalidRequestException("Hours of movie showing is required");
    }
}
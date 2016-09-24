package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.CalendarDto;
import pl.com.bottega.cinema.api.dto.ShowsDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateShowsRequest {

    private Long cinemaId;
    private ShowsDto shows;

    public void validate() {
        entityIdValidate(cinemaId, "Cinema id is incorrect");
        shows.validate();
    }

    public CalendarDto getCalendar() {
        return shows.getCalendar();
    }

    public Collection<LocalDateTime> getShowDates() {
        return shows.getDates();
    }

    public Collection<DayOfWeek> getWeekDays() {
        return shows.getCalendar().getWeekDays();
    }

    public LocalDate getFromDate() {
        return shows.getCalendar().getFromDate().toLocalDate();
    }

    public LocalDate getUntilDate() {
        return shows.getCalendar().getUntilDate().toLocalDate();
    }

    public Collection<LocalTime> getHours() {
        return shows.getCalendar().getHours();
    }

    public Long getMovieId() {
        return shows.getMovieId();
    }
}

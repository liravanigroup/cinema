package pl.com.bottega.cinema.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */
public class ShowsDto {

    private Long movieId;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm")
    private Collection<LocalDateTime> dates;
    private CalendarDto calendar;


    public CalendarDto getCalendar() {
        return calendar;
    }

    public void setCalendar(CalendarDto calendar) {
        this.calendar = calendar;
    }

    public ShowsDto() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Collection<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(Collection<LocalDateTime> dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "ShowsDto{" +
                "movieId=" + movieId +
                ", dates=" + dates +
                ", calendarDto=" + calendar +
                '}';
    }
}

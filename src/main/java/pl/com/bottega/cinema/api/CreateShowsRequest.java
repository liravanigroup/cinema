package pl.com.bottega.cinema.api;

import java.util.Collection;
import java.util.Date;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
public class CreateShowsRequest {
    private Long movieId;
    private Collection<Date> dates;
    private CalendarDto calendar;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Collection<Date> getDates() {
        return dates;
    }

    public void setDates(Collection<Date> dates) {
        this.dates = dates;
    }

    public CalendarDto getCalendar() {
        return calendar;
    }

    public void setCalendar(CalendarDto calendar) {
        this.calendar = calendar;
    }

    public void validate() {
        if (movieId == null)
            throw new InvalidRequestException("Movie Id is required");
        if (dates == null || dates.size()<=0)
            throw new IllegalArgumentException("Dates of show is required");
        calendar.validate();
    }
}
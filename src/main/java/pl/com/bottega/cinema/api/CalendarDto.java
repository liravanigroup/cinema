package pl.com.bottega.cinema.api;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Admin on 10.09.2016.
 */
public class CalendarDto {
    private Date fromDate;
    private Date untilDate;
    private Collection<String> weekDays;
    private Collection<String> hours;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = untilDate;
    }

    public Collection<String> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Collection<String> weekDays) {
        this.weekDays = weekDays;
    }

    public Collection<String> getHours() {
        return hours;
    }

    public void setHours(Collection<String> hours) {
        this.hours = hours;
    }

    public void validate() {
        if (fromDate == null || fromDate.getTime() < new Date().getTime())
            throw new InvalidRequestException("First date of movie showing is required");
        if (untilDate == null || untilDate.getTime() < fromDate.getTime())
            throw new InvalidRequestException("Last date of movie showing is required");
        if (weekDays == null || weekDays.size() <= 0)
            throw new InvalidRequestException("Week days of movie showing is required");
        if (hours == null || hours.size() <= 0)
            throw new InvalidRequestException("Hours of movie showing is required");
    }
}
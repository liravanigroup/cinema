package pl.com.bottega.cinema.api;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Admin on 10.09.2016.
 */
public class CalendarDto {
    private Date fromData;
    private Date untilData;
    private Collection<String> weekDays;
    private Collection<String> hours;

    public Date getFromData() {
        return fromData;
    }

    public void setFromData(Date fromData) {
        this.fromData = fromData;
    }

    public Date getUntilData() {
        return untilData;
    }

    public void setUntilData(Date untilData) {
        this.untilData = untilData;
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
        if (fromData == null)
            throw new InvalidRequestException("First date of movie showing is required");
        if (untilData == null)
            throw new InvalidRequestException("Last date of movie showing is required");
        if (weekDays == null || weekDays.size() <= 0)
            throw new InvalidRequestException("Week days of movie showing is required");
        if (hours == null || hours.size() <= 0)
            throw new InvalidRequestException("Hours of movie showing is required");
    }
}
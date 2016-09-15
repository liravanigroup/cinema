package pl.com.bottega.cinema.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

/**
 * Created by Admin on 10.09.2016.
 */

public class CalendarDto {
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime fromDate;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime untilDate;
    private Collection<DayOfWeek> weekDays;
    @JsonFormat(pattern = "HH:mm")
    private Collection<LocalTime> hours;

    public CalendarDto() {
    }

    public CalendarDto(LocalDateTime fromDate, LocalDateTime untilDate, Collection<DayOfWeek> weekDays, Collection<LocalTime> hours) {
        this.fromDate = fromDate;
        this.untilDate = untilDate;
        this.weekDays = weekDays;
        this.hours = hours;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(LocalDateTime untilDate) {
        this.untilDate = untilDate;
    }

    public Collection<DayOfWeek> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Collection<DayOfWeek> weekDays) {
        this.weekDays = weekDays;
    }

    public Collection<LocalTime> getHours() {
        return hours;
    }

    public void setHours(Collection<LocalTime> hours) {
        this.hours = hours;
    }

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

    @Override
    public String toString() {
        return "CalendarDto{" +
                "fromDate=" + fromDate +
                ", untilDate=" + untilDate +
                ", weekDays=" + weekDays +
                ", hours=" + hours +
                '}';
    }
}
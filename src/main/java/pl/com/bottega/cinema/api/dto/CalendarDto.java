package pl.com.bottega.cinema.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;
import static pl.com.bottega.cinema.domain.validators.DateValidator.dateSequenceValidate;
import static pl.com.bottega.cinema.domain.validators.ObjectValidator.notNullValidate;

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
    private Set<LocalTime> hours;

    public void validate() {
        notNullValidate(fromDate, "First date of movie showing is required");
        notNullValidate(untilDate, "Last date of movie showing is required");
        dateSequenceValidate(fromDate, untilDate, "Dates sequence is incorrect");
        collectionValidate(weekDays, "Week days of movie showing is required");
        collectionValidate(hours, "Hours of movie showing is required");
    }
}
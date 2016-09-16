package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */

@Component
@AllArgsConstructor
public class ShowsFactory {

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;

    Collection<Show> createShow(Long cinemaId, CreateShowsRequest request) {
        ShowsDto showsDto = request.getShows();
        CalendarDto calendarDto = showsDto.getCalendar();

        Cinema cinema = cinemaRepository.load(cinemaId);
        Movie movie = movieRepository.load(showsDto.getMovieId());

        validate(cinema, movie);

        if (calendarDto == null) {
            showsDto.validate();
            return createShow(cinema, movie, showsDto.getDates());
        } else {
            calendarDto.validate();
            return createShow(cinema, movie, calendarDto.getFromDate(), calendarDto.getUntilDate(),
                    calendarDto.getWeekDays(), calendarDto.getHours());
        }
    }

    private Collection<Show> createShow(Cinema cinema, Movie movie, LocalDateTime from, LocalDateTime until, Set<DayOfWeek> days, Collection<LocalTime> hours) {
        Set<Show> result = new HashSet<>();
        for (DayOfWeek day : days) {
            LocalDateTime thisDayOfWeek = from.with(day);
            LocalDateTime fromDate = getFromDate(from, thisDayOfWeek);
            while (fromDate.isBefore(until)) {
                for (LocalTime time : hours) {
                    LocalDateTime dateOfShow = LocalDateTime.of(fromDate.getYear(), fromDate.getMonth(), fromDate.getDayOfMonth(), time.getHour(), time.getMinute());
                    if (dateOfShow.isBefore(until)) {
                        result.add(new Show(cinema, movie, dateOfShow.toLocalDate(), dateOfShow.toLocalTime()));
                    }
                }
                fromDate = fromDate.plusWeeks(1);
            }
        }
        return result;
    }

    private Collection<Show> createShow(Cinema cinema, Movie movie, Collection<LocalDateTime> dates) {
        Set<Show> result = new HashSet<>();
        dates.forEach(date -> result.add(new Show(cinema, movie, date.toLocalDate(), date.toLocalTime())));
        return result;
    }

    private LocalDateTime getFromDate(LocalDateTime from, LocalDateTime thisDayOfWeek) {
        return from.isAfter(thisDayOfWeek) ? thisDayOfWeek.plusWeeks(1) : thisDayOfWeek;
    }

    private void validate(Cinema cinema, Movie movie) {
        if (cinema == null)
            throw new InvalidRequestException("Cinema is absent");
        if (movie == null)
            throw new InvalidRequestException("Movie is absent");
    }
}

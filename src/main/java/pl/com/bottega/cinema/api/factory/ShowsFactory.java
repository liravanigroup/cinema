package pl.com.bottega.cinema.api.factory;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.request.CreateShowsRequest;
import pl.com.bottega.cinema.domain.Cinema;
import pl.com.bottega.cinema.domain.Movie;
import pl.com.bottega.cinema.domain.Show;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */
@Component
public class ShowsFactory {

    public Collection<Show> createShows(CreateShowsRequest request, Cinema cinema, Movie movie) {
        if (request.getCalendar() == null)
            return request.getShowDates().stream().map(date -> new Show(cinema, movie, date)).collect(Collectors.toList());
        Collection<Show> resultShows = new LinkedList<>();
        for (DayOfWeek dayOfWeek : request.getWeekDays()) {
            LocalDate dateOfShow = getFirstDateOfShowAtActualDay(request, dayOfWeek);
            while (dateOfShow.isBefore(request.getUntilDate())) {
                for (LocalTime timeOfShow : request.getHours())
                    resultShows.add(new Show(cinema, movie, dateOfShow, timeOfShow));
                dateOfShow = dateOfShow.plusWeeks(1);
            }
        }
        return resultShows;
    }

    private LocalDate getFirstDateOfShowAtActualDay(CreateShowsRequest request, DayOfWeek dayOfWeek) {
        LocalDate thisDayOfWeek = request.getFromDate().with(dayOfWeek);
        return request.getFromDate().isAfter(thisDayOfWeek) ? thisDayOfWeek.plusWeeks(1) : thisDayOfWeek;
    }
}
package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Sergej Povzaniuk on 14.09.2016.
 */

@Component
public class ShowsFactory {

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;

    public ShowsFactory(CinemaRepository cinemaRepository, MovieRepository movieRepository) {
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
    }

    private Collection<Show> createShow(Cinema cinema, Movie movie, Collection<LocalDateTime> dates) {
        Collection<Show> result = new LinkedList<>();
        dates.forEach(date -> result.add(new Show(cinema, movie, date)));
        return result;
    }


    private Collection<Show> createShow(Cinema cinema, Movie movie, LocalDateTime from, LocalDateTime until, Set<DayOfWeek> days, Collection<LocalTime> hours) {
        Collection<Show> result = new LinkedList<>();
        for (DayOfWeek day : days) {
            LocalDateTime thisDayOfWeek = from.with(day);
            LocalDateTime fromDate = getFromDate(from, thisDayOfWeek);
            while (fromDate.isBefore(until)) {
                for (LocalTime time : hours) {
                    LocalDateTime dateOfShow = LocalDateTime.of(fromDate.getYear(), fromDate.getMonth(), fromDate.getDayOfMonth(), time.getHour(), time.getMinute());
                    if (dateOfShow.isBefore(until)) {
                        result.add(new Show(cinema, movie, dateOfShow));
                    }
                }
                fromDate = fromDate.plusWeeks(1);
            }
        }
        return result;
    }

    private void validate(Cinema cinema, Movie movie) {
        if (cinema == null)
            throw new InvalidRequestException("Cinema is absent");
        if (movie == null)
            throw new InvalidRequestException("Movie is absent");
    }

    private LocalDateTime getFromDate(LocalDateTime from, LocalDateTime thisDayOfWeek) {
        LocalDateTime fromDate;
        if (from.isAfter(thisDayOfWeek)) {
            fromDate = thisDayOfWeek.plusWeeks(1);
        } else {
            fromDate = thisDayOfWeek;
        }
        return fromDate;
    }

    public Collection<Show> createShow(Long cinemaId, CreateShowsRequest request) {
        ShowsDto showsDto = request.getShows();
        CalendarDto calendarDto = showsDto.getCalendar();

        Cinema cinema = cinemaRepository.load(cinemaId);
        Movie movie = movieRepository.load(showsDto.getMovieId());

        validate(cinema, movie);

        if (calendarDto == null) {
            return createShow(cinema, movie, showsDto.getDates());
        } else {
            return createShow(cinema, movie, calendarDto.getFromDate(), calendarDto.getUntilDate(),
                    calendarDto.getWeekDays(), calendarDto.getHours());
        }

    }
}

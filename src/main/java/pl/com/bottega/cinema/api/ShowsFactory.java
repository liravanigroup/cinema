package pl.com.bottega.cinema.api;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.domain.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

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

    private Collection<Show> createShow(Long cinemaId, Long movieId, Collection<LocalDateTime> dates) {
        Collection<Show> result = new LinkedList<>();
        dates.forEach(date -> result.add(new Show(cinemaRepository.load(cinemaId), movieRepository.load(movieId), date)));
        return result;
    }


    private Collection<Show> createShow(Long cinemaId, Long movieId, LocalDateTime from, LocalDateTime until, Collection<DayOfWeek> days, Collection<LocalTime> hours) {
        System.out.println(cinemaId);
        System.out.println(movieId);
        System.out.println(from);
        System.out.println(until);
        System.out.println(days);
        System.out.println(hours);
        return null;
    }

    public Collection<Show> createShow(Long cinemaId, CreateShowsRequest request) {
        ShowsDto showsDto = request.getShows();
        CalendarDto calendarDto = showsDto.getCalendar();

        if (calendarDto == null) {
            return createShow(cinemaId, showsDto.getMovieId(), showsDto.getDates());
        } else {
            return createShow(cinemaId, showsDto.getMovieId(), calendarDto.getFromDate(), calendarDto.getUntilDate(),
                    calendarDto.getWeekDays(), calendarDto.getHours());
        }

    }
}

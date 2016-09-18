package pl.com.bottega.cinema.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cinema.api.InvalidRequestException;
import pl.com.bottega.cinema.api.ListMoviesResponse;
import pl.com.bottega.cinema.api.MovieCatalog;
import pl.com.bottega.cinema.api.MovieResponseDto;
import pl.com.bottega.cinema.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 14.09.2016.
 */
@Component
public class JPAMovieCatalog implements MovieCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListMoviesResponse findMoviesInCinemaByDate(Long cinemaId, Date date) {
        validate(cinemaId, date);
        LocalDate showDate = convertToLocalDate(date);
        return new ListMoviesResponse(getMoviesDto(cinemaId, showDate));
    }

    private List<MovieResponseDto> getMoviesDto(Long cinemaId, LocalDate date) {
        return entityManager.createQuery("Select m FROM Movie m JOIN m.shows s JOIN s.cinema c " +
                "WHERE c.id=:cinemaId AND s.date=:date ORDER BY m.title, s.time", Movie.class)
                .setParameter("cinemaId", cinemaId)
                .setParameter("date", date)
                .getResultList().stream().map(MovieResponseDto::new).collect(Collectors.toList());
    }

    private LocalDate convertToLocalDate(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    private void validate(Long cinemaId, Date date) {
        if (cinemaId == null)
            throw new InvalidRequestException("Ciname id is required");
        if (cinemaId < 0)
            throw new InvalidRequestException("Ciname id is wrong");
        if (date == null)
            throw new InvalidRequestException("Date of show is required");
    }
}

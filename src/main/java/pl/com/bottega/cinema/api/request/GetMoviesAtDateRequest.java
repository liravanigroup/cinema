package pl.com.bottega.cinema.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.InvalidRequestException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@Getter
@Setter
public class GetMoviesAtDateRequest {

    private Long cinemaId;
    private LocalDate date;

    public GetMoviesAtDateRequest(String date) {
        this.date = getValidDate(date);
    }

    private LocalDate getValidDate(String date) {
        try{
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }catch (DateTimeParseException ex){
            throw new InvalidRequestException(ex.getMessage());
        }
    }

    public void validate() {
        entityIdValidate(cinemaId, "Cinema id is incorrect");
    }
}
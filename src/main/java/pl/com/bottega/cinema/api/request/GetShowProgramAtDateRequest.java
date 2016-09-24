package pl.com.bottega.cinema.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static pl.com.bottega.cinema.domain.validators.NumberValidator.entityIdValidate;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class GetShowProgramAtDateRequest {

    private Long cinemaId;
    private LocalDate date;

    public GetShowProgramAtDateRequest(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public void validate() {
        entityIdValidate(cinemaId, "Cinema id is incorrect");
    }
}
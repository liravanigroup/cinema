package pl.com.bottega.cinema.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static pl.com.bottega.cinema.domain.validators.Validator.entityIdValidate;

/**
 * Created by Sergej Povzaniuk on 23.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetShowProgramAtDateRequest {

    private Long cinamaId;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    public void validate(){
        entityIdValidate(cinamaId, "Cinema id is incorrect");

    }
}

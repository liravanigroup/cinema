package pl.com.bottega.cinema.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.dto.ShowsDto;

import static pl.com.bottega.cinema.domain.Validator.entityIdValidate;

/**
 * Created by bernard.boguszewski on 04.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateShowsRequest {
    private ShowsDto shows;
    private Long cinemaId;

    public void validate() {
        entityIdValidate(cinemaId, "Cinema id is incorrect");
        shows.validate();
    }
}

package pl.com.bottega.cinema.ui;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Admin on 15.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowData {
    private Long id;
    @JsonFormat(pattern="HH:mm")
    private LocalTime time;
}

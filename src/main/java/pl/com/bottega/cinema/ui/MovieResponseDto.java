package pl.com.bottega.cinema.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Admin on 15.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private String title;
    private String description;
    private Set<String> actors;
    private Set<String> genres;
    private Integer minAge;
    private Integer length;
    private Collection<ShowData> shows;
}
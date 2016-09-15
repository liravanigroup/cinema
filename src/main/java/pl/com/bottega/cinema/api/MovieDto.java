package pl.com.bottega.cinema.api;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MovieDto {

    private String title;
    private String description;
    private Set<String> actors;
    private Set<String> genres;
    private Integer minAge;
    private Integer length;

    void validate() {
        if (title == null || title.trim().length() <= 2)
            throw new InvalidRequestException("Title is required");
        if (description == null || description.trim().length() <= 10)
            throw new InvalidRequestException("Description is required");
        if (actors == null || actors.size() <= 0)
            throw new InvalidRequestException("Actors is required");
        if (genres == null || genres.size() <= 0)
            throw new InvalidRequestException("Genres is required");
        if (minAge == null || minAge <= 0)
            throw new InvalidRequestException("Min age is required");
        if (length == null || length <= 0)
            throw new InvalidRequestException("Length is required");
    }
}

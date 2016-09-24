package pl.com.bottega.cinema.api.dto;/* Created by Sergej on 04.09.2016. Bottega IT Solutions */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static pl.com.bottega.cinema.domain.validators.CollectionValidator.collectionValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.minAgeValidate;
import static pl.com.bottega.cinema.domain.validators.NumberValidator.movieLengthValidate;
import static pl.com.bottega.cinema.domain.validators.StringValidator.stringValidate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String title;
    private String description;
    private Set<String> actors;
    private Set<String> genres;
    private Integer minAge;
    private Integer length;

    public void validate() {
        stringValidate(title, "Title is required");
        stringValidate(description, "Description is required");
        collectionValidate(actors, "Actors is required");
        collectionValidate(genres, "Genres is required");
        minAgeValidate(minAge, "Min age is required");
        movieLengthValidate(length, "Length is required");
    }

}

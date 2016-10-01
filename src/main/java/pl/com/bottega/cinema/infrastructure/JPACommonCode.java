package pl.com.bottega.cinema.infrastructure;

import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 01.10.2016.
 */
@NoArgsConstructor(access = PRIVATE)
class JPACommonCode {

    static <T> T getSingleObject(List<T> objects){
        return objects.isEmpty() ? null : objects.get(0);
    }
}

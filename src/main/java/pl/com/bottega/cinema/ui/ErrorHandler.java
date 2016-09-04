package pl.com.bottega.cinema.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.bottega.cinema.api.InvalidRequestException;

/**
 * Created by anna on 04.09.2016.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<String>(
                "{'error': 'invalid_request_exception'}",
                headers,
                HttpStatus.UNPROCESSABLE_ENTITY

        );
    }
}

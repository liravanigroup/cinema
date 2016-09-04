package pl.com.bottega.cinema.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.bottega.cinema.api.InvalidRequestException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anna on 04.09.2016.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(HttpServletRequest request, InvalidRequestException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<String>(
                "{'error': " + ex.getMessage() + "}",
                headers,
                HttpStatus.UNPROCESSABLE_ENTITY

        );
    }
}

package pl.com.bottega.cinema.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.bottega.cinema.api.InvalidRequestException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

/**
 * Created by anna on 04.09.2016.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(HttpServletRequest request, InvalidRequestException ex) {
        HttpHeaders headers = new HttpHeaders();
        setContentTypeAsJsonFormat(headers);
        return getStringResponseEntity(ex, headers);
    }

    private void setContentTypeAsJsonFormat(HttpHeaders headers) {
        headers.set(CONTENT_TYPE, "application/json");
    }

    private ResponseEntity<String> getStringResponseEntity(InvalidRequestException ex, HttpHeaders headers) {
        return new ResponseEntity<String>("{'error':" + ex.getMessage() + "}", headers, UNPROCESSABLE_ENTITY);
    }
}

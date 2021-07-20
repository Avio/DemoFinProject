package net.example.demofinproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler({ConnectException.class})
    public ResponseEntity<String> handle(ConnectException ex) {
        return new ResponseEntity<>("Service unavailable now. Try later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

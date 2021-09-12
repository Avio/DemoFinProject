package net.example.demofinproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler({ConnectException.class, SocketTimeoutException.class})
    public ResponseEntity<String> handle(Exception ex) {
        return new ResponseEntity<>("Service unavailable now. Try later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ContractNotFoundException.class)
    public ResponseEntity handleContractNotFound(ContractNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("ContractEntity Not Found", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

}

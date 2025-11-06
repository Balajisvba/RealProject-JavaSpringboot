package com.RealProject.RealProject.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> cusotmerNotFound(CustomerNotFoundException ex){
        return new ResponseEntity<>("Customer Not Found"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runTimeException(RuntimeException ex){
        return new ResponseEntity<>("Run Time Exception"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenralException(Exception ex){
        return new ResponseEntity<>("Something went Worng"+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


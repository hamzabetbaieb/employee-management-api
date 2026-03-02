package com.example.employee_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Error> handleDepartmentNotFound(DepartmentNotFoundException ex){

        Error error = new Error(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Error> handleEmployeeNotFound(EmployeeNotFoundException ex){
        Error error = new Error(ex.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Error> handleDuplicate(DuplicateResourceException ex) {

        Error error = new Error(
                ex.getMessage(),
                HttpStatus.CONFLICT.value()
        );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}

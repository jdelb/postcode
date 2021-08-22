package com.example.postcode;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    
    private final Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> handle(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        String errorMessage = "";
        List<String> errors = new ArrayList<String>();
        if (!violations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            violations.forEach(violation -> builder.append("\n" + violation.getMessage()));
            violations.forEach(violation -> errors.add(violation.getMessage()));
            errorMessage = builder.toString();
            
        } else {
            errorMessage = "ConstraintViolationException occured.";
        }

        logger.error(errorMessage);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
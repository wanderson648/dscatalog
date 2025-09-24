package com.devsuperior.auladev.exception.handler;

import com.devsuperior.auladev.exception.DatabaseException;
import com.devsuperior.auladev.exception.ResourceNotFoundException;
import com.devsuperior.auladev.exception.StandardError;
import com.devsuperior.auladev.exception.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(ResourceNotFoundException e,
                                                                 HttpServletRequest request) {
        StandardError error = new StandardError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
               "Resource not found",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DatabaseException e,
                                                                         HttpServletRequest request) {
        StandardError error = new StandardError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Integrity violation",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException e,
                                                                         HttpServletRequest request) {
        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Validation error");
        error.setMessage(error.getMessage());
        error.setPath(request.getRequestURI());

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

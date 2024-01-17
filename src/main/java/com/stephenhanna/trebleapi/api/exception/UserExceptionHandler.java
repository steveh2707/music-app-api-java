package com.stephenhanna.trebleapi.api.exception;

import com.stephenhanna.trebleapi.model.exception.ApiExceptionModel;
import com.stephenhanna.trebleapi.service.exception.EmailAlreadyExistsException;
import com.stephenhanna.trebleapi.service.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<ApiExceptionModel> userNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(
                ApiExceptionModel
                        .builder()
                        .exceptionMessage(e.getMessage())
                        .message("No user exists")
                        .timestamp(Instant.now()).build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({EmailAlreadyExistsException.class})
    public final ResponseEntity<ApiExceptionModel> emailAlreadyExistsException(EmailAlreadyExistsException e) {
        return new ResponseEntity<>(
                ApiExceptionModel
                        .builder()
                        .exceptionMessage(e.getMessage())
                        .message("Email address already in use")
                        .timestamp(Instant.now()).build(),
                HttpStatus.BAD_REQUEST
        );
    }
}

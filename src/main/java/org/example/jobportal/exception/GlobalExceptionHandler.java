package org.example.jobportal.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JobPortalException.class)
    public ResponseEntity<ExceptionResponse> handleJobPortalException(JobPortalException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setHttpStatus(ex.getStatus());
        exceptionResponse.setTime(LocalDateTime.now());
        return ResponseEntity.status(ex.getStatus()).body(exceptionResponse);
    }

}

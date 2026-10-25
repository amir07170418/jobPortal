package org.example.jobportal.exception;

import org.springframework.http.HttpStatus;

public class JobPortalException extends RuntimeException {
    private final HttpStatus status;

    public JobPortalException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

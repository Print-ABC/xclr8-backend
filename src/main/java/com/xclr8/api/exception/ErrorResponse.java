package com.xclr8.api.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponse {
    private HttpStatus status;
    private String errorCode;
    private String timeStamp;
    private String message;

    public ErrorResponse() {}

    public ErrorResponse(HttpStatus status, int errorCode, String message) {
        this.status = status;
        this.errorCode = String.valueOf(errorCode);
        this.timeStamp = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }
}

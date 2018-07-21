package com.xclr8.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    ExceptionMessage mExceptionMessage;

    /**
     * General handler to catch all exceptions
     * @param ex
     */
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGeneralException(Exception ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());
    }

    /**
     * Handles 500 Internal Server Errors returned by RequestMethod.GET queries
     * Errors are identified as NullPointer exceptions thrown when calling findBy methods of MongoRepository (extended from CrudRepository)
     * @param ex
     */
    @ExceptionHandler(NullPointerException.class)
    public ErrorResponse handleNullPointerException(NullPointerException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), mExceptionMessage.RESOURCE_NOT_FOUND.getMsg());
    }

    /**
     * Handles exceptions thrown due to missing request body during a POST request
     * Requires @RequestBody annotation in controller method
     * POST methods without @RequestBody annotation will throw CustomBadRequestException instead
     * @param ex
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), mExceptionMessage.REQUEST_BODY_ERROR.getMsg());
    }

    /**
     * Handles exceptions thrown when trying to access unsupported REST services
     * @param ex
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getLocalizedMessage()
                + ". " + mExceptionMessage.INVALID_REQUEST.getMsg());
    }

    // CUSTOM EXCEPTIONS

    /**
     * Custom not found exception handler
     * @param ex
     */
    @ExceptionHandler(CustomNotFoundException.class)
    public ErrorResponse handleNotFoundException(CustomNotFoundException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
    }

    /**
     * Handles null pointer exceptions that occurs during a POST request
     * POST methods using @RequestBody annotation will throw HttpMessageNotReadableException instead
     * @param ex
     */
    @ExceptionHandler(CustomBadRequestException.class)
    public ErrorResponse handleCustomRequestFormException(CustomBadRequestException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());
    }
}

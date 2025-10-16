package com.example.contacts.exceptions;

import com.example.contacts.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleContactNotFoundException(ContactNotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(NoResultsException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorResponse handleNoResultsFoundException(NoResultsException e) {
        return new ErrorResponse(e.getMessage());
    }
}

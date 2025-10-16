package com.example.contacts.exceptions;

import com.example.contacts.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class NoResultsException extends RuntimeException{
    public NoResultsException() {
        super(ErrorMessages.NO_RESULTS.getMessage());
    }
}

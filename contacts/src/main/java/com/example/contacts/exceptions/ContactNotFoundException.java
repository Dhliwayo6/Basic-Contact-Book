package com.example.contacts.exceptions;

import com.example.contacts.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException() {
        super(ErrorMessages.CONTACT_NOT_FOUND.getMessage());
    }
}

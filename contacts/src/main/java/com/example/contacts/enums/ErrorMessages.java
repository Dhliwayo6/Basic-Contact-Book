package com.example.contacts.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {
    CONTACT_NOT_FOUND("Contact not found"),
    NO_RESULTS("No results found");

    private String message;
}

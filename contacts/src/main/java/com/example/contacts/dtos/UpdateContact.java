package com.example.contacts.dtos;

import com.example.contacts.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateContact {
    private Integer id;
    private Contact contact;
}

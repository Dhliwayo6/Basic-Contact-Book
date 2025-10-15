package com.example.contacts.dtos;

import com.example.contacts.model.Address;
import com.example.contacts.model.Contact;
import lombok.Data;

@Data
public class ContactDTO {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String number;
    private String nickname;
    private Address address;

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.surname = contact.getSurname();
        this.email = contact.getEmail();
        this.number = contact.getNumber();
        this.nickname = contact.getNickname();
        this.address = contact.getAddress();
    }

}

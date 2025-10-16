package com.example.contacts.services;

import com.example.contacts.Query;
import com.example.contacts.dtos.ContactDTO;
import com.example.contacts.model.Contact;
import com.example.contacts.repositories.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetContactsService implements Query<Void, List<ContactDTO>> {

    private ContactRepository contactRepository;

    public GetContactsService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ResponseEntity<List<ContactDTO>> execute(Void input) {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactDTO> contactDTOS = contacts.stream().map(ContactDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(contactDTOS);
    }
}

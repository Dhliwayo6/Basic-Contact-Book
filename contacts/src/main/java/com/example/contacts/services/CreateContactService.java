package com.example.contacts.services;

import com.example.contacts.Command;
import com.example.contacts.dtos.ContactDTO;
import com.example.contacts.model.Contact;
import com.example.contacts.repositories.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateContactService implements Command<Contact, ContactDTO> {

    private ContactRepository contactRepository;

    public CreateContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ResponseEntity<ContactDTO> execute(Contact contact) {
        Contact contactSaved = contactRepository.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ContactDTO(contactSaved));

    }

}

package com.example.contacts.services.contact;

import com.example.contacts.Query;
import com.example.contacts.dtos.ContactDTO;
import com.example.contacts.model.Contact;
import com.example.contacts.repositories.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetContactService implements Query<Integer, ContactDTO> {

    private ContactRepository contactRepository;

    public GetContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ResponseEntity<ContactDTO> execute(Integer id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            return ResponseEntity.ok(new ContactDTO(contactOptional.get()));
        }

        throw new IllegalArgumentException("Contact not found!");
    }
}

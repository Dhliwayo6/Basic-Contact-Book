package com.example.contacts.services;

import com.example.contacts.Command;
import com.example.contacts.dtos.ContactDTO;
import com.example.contacts.dtos.UpdateContact;
import com.example.contacts.model.Contact;
import com.example.contacts.repositories.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateContactService implements Command<UpdateContact, ContactDTO> {

    private ContactRepository contactRepository;

    public UpdateContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ResponseEntity<ContactDTO> execute(UpdateContact updateContact) {
        Optional<Contact> contactOptional = contactRepository.findById(updateContact.getId());

        if (contactOptional.isPresent()) {
            Contact contact = updateContact.getContact();
            contact.setId(updateContact.getId());
            contactRepository.save(contact);
            return ResponseEntity.ok(new ContactDTO(contact));
        }

        throw new IllegalArgumentException("Contact not found!");
    }
}

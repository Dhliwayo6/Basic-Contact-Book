package com.example.contacts.controllers;

import com.example.contacts.dtos.ContactDTO;
import com.example.contacts.dtos.UpdateContact;
import com.example.contacts.model.Contact;
import com.example.contacts.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private CreateContactService createContactService;
    private GetContactsService getContactsService;
    private GetContactService getContactService;
    private UpdateContactService updateContactService;
    private DeleteContactService deleteContactService;

    public ContactController(CreateContactService createContactService,
                             GetContactsService getContactsService,
                             GetContactService getContactService,
                             UpdateContactService updateContactService,
                             DeleteContactService deleteContactService) {
        this.createContactService = createContactService;
        this.getContactsService = getContactsService;
        this.getContactService = getContactService;
        this.updateContactService = updateContactService;
        this.deleteContactService = deleteContactService;
    }

    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> createContact(@RequestBody Contact contact) {
        return createContactService.execute(contact);
    }

    @GetMapping("/contact{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Integer id) {
        return getContactService.execute(id);
    }

    @GetMapping("contacts")
    public ResponseEntity<List<ContactDTO>> getContacts() {
        return getContactsService.execute(null);
    }

    @PutMapping("/contact{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        return updateContactService.execute(new UpdateContact(id, contact));
    }

    @DeleteMapping("/contact{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        return deleteContactService.execute(id);
    }
}

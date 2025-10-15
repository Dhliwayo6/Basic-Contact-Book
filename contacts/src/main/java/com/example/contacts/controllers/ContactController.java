package com.example.contacts.controllers;

import com.example.contacts.dtos.ContactDTO;
import com.example.contacts.model.Contact;
import com.example.contacts.services.contact.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/contact")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Integer id) {
        return getContactService.execute(id);
    }
}

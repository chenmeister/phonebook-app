package io.chenmeister.phonebookapp.controller;

import io.chenmeister.phonebookapp.model.Contact;
import io.chenmeister.phonebookapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAll() {
        return contactService.getAllContacts();
    }

    @GetMapping(path = "{id}")
    public Contact getContact(@PathVariable("id") UUID id) {
        return contactService.getContactById(id)
                .orElse(null);
    }

    @PostMapping
    public int createNewContact(@RequestBody Contact contact) {
        return contactService.insertNewContact(contact);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") UUID id, @RequestBody Contact contact) {
        contactService.updateContact(id, contact);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContact(@PathVariable("id") UUID id) {
        contactService.deleteContact(id);
    }

}

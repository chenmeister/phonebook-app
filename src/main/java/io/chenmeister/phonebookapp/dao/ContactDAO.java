package io.chenmeister.phonebookapp.dao;

import io.chenmeister.phonebookapp.model.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactDAO {

    int addContact(UUID id, Contact contact);

    default int addContact(Contact contact) {
        UUID id = UUID.randomUUID();
        return addContact(id, contact);
    }

    List<Contact> getAllContacts();

    Optional<Contact> getContact(UUID id);

    int updateContact(UUID id, Contact contact);

    int deleteContact(UUID id);

}

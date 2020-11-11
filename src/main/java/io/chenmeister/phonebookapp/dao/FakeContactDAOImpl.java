package io.chenmeister.phonebookapp.dao;

import io.chenmeister.phonebookapp.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeContactDAOImpl implements ContactDAO {

    private final static List<Contact> DB = new ArrayList<>();

    @Override
    public UUID addContact(UUID id, Contact contact) {
        DB.add(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone()));
        return id;
    }

    @Override
    public List<Contact> getAllContacts() {
        return DB;
    }

    @Override
    public Optional<Contact> getContact(UUID id) {
        return DB
            .stream()
            .filter(contact -> contact.getId().equals(id))
            .findFirst();
    }

    @Override
    public int updateContact(UUID id, Contact contactUpdate) {
        return getContact(id)
                .map(contact -> {
                    int indexOfContactToDelete = DB.indexOf(contact);
                    if (indexOfContactToDelete >= 0) {
                        DB.set(indexOfContactToDelete, new Contact(id, contactUpdate.getFirstName(), contactUpdate.getLastName(), contactUpdate.getEmail(), contactUpdate.getPhone()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteContact(UUID id) {
        Optional<Contact> contactOptional = getContact(id);
        if(!contactOptional.isPresent()) {
            return 0;
        }
        DB.remove(contactOptional.get());
        return 1;
    }
}

package io.chenmeister.phonebookapp.service;

import io.chenmeister.phonebookapp.dao.ContactDAO;
import io.chenmeister.phonebookapp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService {

    private final ContactDAO contactDAO;

    @Autowired
    public ContactService(@Qualifier("postgres") ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    public int insertNewContact(Contact contact) {
        return contactDAO.addContact(contact);
    }

    public Optional<Contact> getContactById(UUID contactId) {
        return contactDAO.getContact(contactId);
    }

    public void deleteContact(UUID contactId) {
        contactDAO.deleteContact(contactId);
    }

    public void updateContact(UUID contactId, Contact contact) {
        contactDAO.updateContact(contactId, contact);
    }

}

package io.chenmeister.phonebookapp.dao;

import io.chenmeister.phonebookapp.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ContactDAOImpl implements ContactDAO {

    private final JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addContact(UUID id, Contact contact) {
        final String sql = "insert into contact values (?, ?, ?, ?, ?)";
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        String email = contact.getEmail();
        String phone = contact.getPhone();
        return jdbcTemplate.update(sql, id, firstName, lastName, email, phone);

    }

    @Override
    public List<Contact> getAllContacts() {
        final String sql = "select * from contact";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            return new Contact(id, firstName, lastName, email, phone);
        });
    }

    @Override
    public Optional<Contact> getContact(UUID id) {
        final String sql = "select * from contact where id = ?";
        Contact contact =  jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID getId = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            return new Contact(getId, firstName, lastName, email, phone);
        });
        return Optional.ofNullable(contact);
    }

    @Override
    public int updateContact(UUID id, Contact contact) {
        final String sql = "update contact set firstname = ?, lastname = ?, email = ?, phone = ? where id = ?";
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        String email = contact.getEmail();
        String phone = contact.getPhone();
        return jdbcTemplate.update(sql, firstName, lastName, email, phone, id);
    }

    @Override
    public int deleteContact(UUID id) {
        final String sql = "delete from contact where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

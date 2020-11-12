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
    public UUID addContact(UUID id, Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        final String sql = "select * from contact";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            return new Contact(
                    id,
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone")
            );
        });
    }

    @Override
    public Optional<Contact> getContact(UUID id) {
        return Optional.empty();
    }

    @Override
    public int updateContact(UUID id, Contact contact) {
        return 0;
    }

    @Override
    public int deleteContact(UUID id) {
        return 0;
    }
}

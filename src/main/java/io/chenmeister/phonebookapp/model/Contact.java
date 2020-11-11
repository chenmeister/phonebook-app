package io.chenmeister.phonebookapp.model;

import java.util.UUID;

public class Contact {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Contact(
            UUID id,
            String firstName,
            String lastName,
            String email,
            String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}

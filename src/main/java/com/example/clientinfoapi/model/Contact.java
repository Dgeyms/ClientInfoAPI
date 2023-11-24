package com.example.clientinfoapi.model;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Contact {
    private Client client;
    private ContactType contactType;
    private String value;

    public void setClientId(Optional<Client> client) {
        this.client = client;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package com.example.clientinfoapi.model;

import org.springframework.stereotype.Component;

@Component
public class Contact {
    private Client client;
    private ContactType contactType;
    private String value;

    public void setClientId(Client client) {
        this.client = client;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package com.example.clientinfoapi.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Optional<Client> id;
    @Enumerated(EnumType.STRING)
    private ContactType contactType;
    private String value;

    @ManyToMany
    @JoinColumn(name = "client_id")
    private Client client;

    public void setId(Optional<Client> id) {
        this.id = id;
    }
    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

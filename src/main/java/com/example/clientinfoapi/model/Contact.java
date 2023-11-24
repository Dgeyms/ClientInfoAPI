package com.example.clientinfoapi.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Client id;
    @Enumerated(EnumType.STRING)
    private ContactType contactType;
    private String value;

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(Client id) {
        this.id = id;
    }
}

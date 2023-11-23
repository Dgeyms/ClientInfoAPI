package com.example.clientinfoapi.model;

import org.springframework.stereotype.Component;

@Component
public class Contact {
    private Long id;
    private ContactType contactType;
    private String value;
}

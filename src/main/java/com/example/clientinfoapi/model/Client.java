package com.example.clientinfoapi.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<Contact> contacts;

    public String getNameClient(String name) {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}

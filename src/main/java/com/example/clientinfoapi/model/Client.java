package com.example.clientinfoapi.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}

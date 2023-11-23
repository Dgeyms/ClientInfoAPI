package com.example.clientinfoapi.model;

import org.springframework.stereotype.Component;

@Component
public class Client {
    private Long id;
    private String nameClient;

    public String getNameClient(String name) {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}

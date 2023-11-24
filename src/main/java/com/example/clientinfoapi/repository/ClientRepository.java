package com.example.clientinfoapi.repository;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client searchClientById(Long clientId);

    void saveNewClient(Client newClient);
}

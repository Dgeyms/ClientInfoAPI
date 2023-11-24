package com.example.clientinfoapi.repository;

import com.example.clientinfoapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Long clientId);

    Object save(Client newClient);
    List<Client> findAll();
}

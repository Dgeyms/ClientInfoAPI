package com.example.clientinfoapi.repository;

import com.example.clientinfoapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

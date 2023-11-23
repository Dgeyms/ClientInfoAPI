package com.example.clientinfoapi.repository;

import com.example.clientinfoapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Этот метод вернет список объектов типа Contact
    // findByClientId: Это шаблонное название метода, где ClientId - это поле в сущности Contact,
    // и Spring Data JPA автоматически создаст SQL-запрос для поиска всех контактов по заданному clientId.
    List<Contact> findByClientId(Long clientId);
}

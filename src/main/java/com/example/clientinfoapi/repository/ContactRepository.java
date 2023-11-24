package com.example.clientinfoapi.repository;

import com.example.clientinfoapi.model.Contact;
import com.example.clientinfoapi.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact save(Contact newContact);

    @Query("SELECT c FROM Contact c WHERE c.client.id = :clientId")
    List<Contact> getListContactsForClient(@Param("clientId") Long clientId);

    @Query("SELECT c FROM Contact c WHERE c.client.id = :clientId AND c.contactType = :contactType")
    List<Contact> getListContactsByTypeClient(Long clientId, ContactType contactType);
}

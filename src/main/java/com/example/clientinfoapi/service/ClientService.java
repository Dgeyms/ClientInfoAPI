package com.example.clientinfoapi.service;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.model.Contact;
import com.example.clientinfoapi.model.ContactType;
import com.example.clientinfoapi.repository.ClientRepository;
import com.example.clientinfoapi.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final ContactType contactType;

    @Autowired
    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository, ContactType contactType) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
        this.contactType = contactType;
    }

    public void addNewClient(String name) {
        Client newClient = new Client();
        newClient.setNameClient(name);
        clientRepository.save(newClient);
    }

    public void addNewContactTypeClient(Long clientId, String contactTypeClient, String value) {
        try {
            ContactType contactType = ContactType.valueOf(contactTypeClient.toUpperCase());
            Optional<Client> client = clientRepository.findById(clientId);
            if (client != null) {
                Contact newContact = new Contact();
                newContact.setContactType(contactType);
                newContact.setValue(value);
                newContact.setId(client);

                contactRepository.save(newContact);
            } else {
                System.out.println("Client with ID not found" + clientId);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientInformationById(Long clientId) {
            Optional<Client> client = clientRepository.findById(clientId);
            return client;
    }


        public void getListContactByClient () {

        }

        public void getContactsByClientIdAndType () {

        }


}

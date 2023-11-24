package com.example.clientinfoapi.service;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.model.Contact;
import com.example.clientinfoapi.model.ContactType;
import com.example.clientinfoapi.repository.ClientRepository;
import com.example.clientinfoapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
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
            if (client.isPresent()) {
                Contact newContact = createNewContact(contactType, value, client.get());
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
        return clientRepository.findById(clientId);
    }

    public List<Contact> getListContactsForClient(Long clientId) {
        List<Contact> listContacts = contactRepository.getListContactsForClient(clientId);
        return listContacts;
    }

    public List<Contact> getListContactsByTypeClient(Long clientId, String contactTypeClient) {
        ContactType contactType = ContactType.valueOf(contactTypeClient.toUpperCase());

        List<Contact> listContactByType = contactRepository.getListContactsByTypeClient(clientId, contactType);
        return listContactByType;
    }

    private Contact createNewContact(ContactType contactType, String value, Client client) {
        Contact newContact = new Contact();
        newContact.setContactType(contactType);
        newContact.setValue(value);
        newContact.setId(client);

        return newContact;
    }
}

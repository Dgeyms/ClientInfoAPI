package com.example.clientinfoapi.service;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.model.Contact;
import com.example.clientinfoapi.model.ContactType;
import com.example.clientinfoapi.repository.ClientRepository;
import com.example.clientinfoapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        clientRepository.saveNewClient(newClient);
    }

    public void addNewContactTypeClient(Long clientId, String contactTypeClient, String value) {
        try {
            ContactType contactType = ContactType.valueOf(contactTypeClient.toUpperCase());
            Client client = clientRepository.searchClientById(clientId);
                if (client != null){
                    Contact newContact = new Contact();
                    newContact.setContactType(contactType);
                    newContact.setValue(value);
                    newContact.setClientId(client);

                    contactRepository.saveNewContactInDataBase(newContact);
                }else{
                    System.out.println("Client with ID not found" + clientId);
                }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getListClient() {

    }

    public void getClientById() {

    }

    public void getListContactByClient() {

    }

    public void getContactsByClientIdAndType() {

    }
}

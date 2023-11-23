package com.example.clientinfoapi.service;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.repository.ClientRepository;
import com.example.clientinfoapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    public void addNewClient(String name){
        Client newClient = new Client();
        newClient.setNameClient(name);
        clientRepository.save(newClient);
    }
    public void addNewContactType(){

    }
    public void getListClient(){

    }
    public void getClientById(){

    }
    public void getListContactByClient(){

    }
    public void getContactsByClientIdAndType(){

    }
}

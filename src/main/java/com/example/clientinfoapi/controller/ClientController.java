package com.example.clientinfoapi.controller;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.model.Contact;
import com.example.clientinfoapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/{nameClient}")
    public void addClient(@PathVariable String nameClient) {
        clientService.addNewClient(nameClient);
    }

    @PostMapping("/addContact/{clientId}")
    public void addNewContactTypeClient(
            @PathVariable Long clientId,
            @RequestParam String contactType,
            @RequestParam String value) {
        clientService.addNewContactTypeClient(clientId, contactType, value);
    }

    @GetMapping("/getListClients")
    public ResponseEntity<List<Client>> getListClients() {
        List<Client> listClients = clientService.findAll();
        if (!listClients.isEmpty()) {
            return new ResponseEntity<>(listClients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getInfoClient/{clientId}")
    public ResponseEntity<Client> getClientInformationById(
            @PathVariable Long clientId) {
        Optional<Client> clientOptional = clientService.getClientInformationById(clientId);
        if (clientOptional.isPresent()) {
            return new ResponseEntity<>(clientOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getListContacts/{clientId}")
    public ResponseEntity<List<Contact>> getListContactsForClient(
            @PathVariable Long clientId) {
        List<Contact> listContactsForClient = clientService.getListContactsForClient(clientId);
        if (!listContactsForClient.isEmpty()) {
            return new ResponseEntity<>(listContactsForClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getContactType/{clienId}")
    public ResponseEntity<List<Contact>> getContactsByTypeForClient(
            @PathVariable Long clientId,
            @RequestParam String contactType) {
        List<Contact> listContactsByTypeClient = clientService.getListContactsByTypeClient(clientId, contactType);
        if (!listContactsByTypeClient.isEmpty()) {
            return new ResponseEntity<>(listContactsByTypeClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

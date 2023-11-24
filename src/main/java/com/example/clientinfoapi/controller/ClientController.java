package com.example.clientinfoapi.controller;

import com.example.clientinfoapi.model.Client;
import com.example.clientinfoapi.model.ContactType;
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
    private final ContactType contactType;
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService, ContactType contactType) {
        this.clientService = clientService;
        this.contactType = contactType;
    }

    @PostMapping("/{nameClient}")
    public void addClient(@PathVariable String nameClient){
        clientService.addNewClient(nameClient);
    }

    @PostMapping("{/addContact/{clientId}")
    public void addNewContactTypeClient(
            @PathVariable Long clientId,
            @RequestParam String contactType,
            @RequestParam String value) {
        clientService.addNewContactTypeClient(clientId, contactType, value);
    }

    @GetMapping("/getListClients")
    public ResponseEntity<List<Client>> getListClients(){
        List<Client> listClients = clientService.findAll();
        if(!listClients.isEmpty()){
            return new ResponseEntity<>(listClients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("getInfoClient/{clientId}")
    public ResponseEntity<Client> getClientInformationById(
            @PathVariable Long clientId){
              Optional<Client> clientOptional = clientService.getClientInformationById(clientId);
              return clientOptional
                      .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

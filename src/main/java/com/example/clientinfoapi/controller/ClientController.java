package com.example.clientinfoapi.controller;

import com.example.clientinfoapi.model.ContactType;
import com.example.clientinfoapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

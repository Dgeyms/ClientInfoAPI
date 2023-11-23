package com.example.clientinfoapi.controller;

import com.example.clientinfoapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ClientService clientService;
    @Autowired
    public ProductController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/{name}")
    public void addClient(@RequestBody String name){
        clientService.addNewClient(name);
    }


}

package com.pmservice.basePackage.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmservice.basePackage.models.Client.Client;
import com.pmservice.basePackage.models.Client.CreateClientRequest;
import com.pmservice.basePackage.models.Client.DeleteClientRequest;
import com.pmservice.basePackage.models.Responses.MappingResponse;
import com.pmservice.basePackage.services.ClientsService;

@RestController
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    @GetMapping("/clients")
    public Collection<Client> getAllClients() {
        return clientsService.findAllClients();
    }

    @GetMapping("/client/id")
    public Client getClientById(Long id) {
        return clientsService.findClientById(id);
    }

    @PostMapping("/client/new")
    public MappingResponse createNewClient(@RequestBody CreateClientRequest request) {
        clientsService.saveNewClient(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("Client: " + request.getClientName() + " successfully created with ID " + request.getId());
        return response;
    }

    @DeleteMapping("/client/delete")
    public MappingResponse deleteClient(@RequestBody DeleteClientRequest request) throws Exception {
        clientsService.deleteClient(request);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("Client: " + request.getId() + " successfully deleted.");
        return response;
    }

    @PutMapping("/client/edit")
    public MappingResponse editClient(Long clientID, @RequestBody String newClientName) {
        clientsService.editClient(clientID, newClientName);
        MappingResponse response = new MappingResponse();
        response.setResponseMessage("Client: " + clientID + " has been renamed to " + newClientName);
        return response;
    }

}

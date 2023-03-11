package com.pmservice.basePackage.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmservice.basePackage.models.Client.Client;
import com.pmservice.basePackage.models.Client.CreateClientRequest;
import com.pmservice.basePackage.models.Client.DeleteClientRequest;
import com.pmservice.basePackage.repos.ClientsRepo;
import com.pmservice.basePackage.services.ClientsService;

@Component
public class ClientsImpl implements ClientsService{

    @Autowired
    ClientsRepo clientsRepo;

    @Override
    public Client findClientById(Long clientId) {
        return clientsRepo.findById(clientId);
    }

    @Override
    public Collection<Client> findAllClients() {
        return clientsRepo.findAll();
    }

    @Override
    public Client saveNewClient(CreateClientRequest request) {
        Client client = new Client();
        client.setId(request.getId());
        client.setClientName(request.getClientName());
        return clientsRepo.save(client);
    }

    @Override
    public Client deleteClient(DeleteClientRequest request) {
        Client client = new Client();
        client = clientsRepo.findById(request.getId());
        return clientsRepo.delete(client);
    }

    @Override
    public Client editClient(Long clientId, String newClientName) {
        Client client = new Client();
        client = clientsRepo.findById(clientId);
        client.setClientName(newClientName);
        return clientsRepo.save(client);
    }
    
}

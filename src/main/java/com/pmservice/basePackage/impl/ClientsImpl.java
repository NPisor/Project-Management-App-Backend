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
    public Client findClientById(Long clientId) throws Exception {
        if(clientsRepo.findById(clientId).isEmpty()){
            throw new Exception("No client found with ID: " + clientId.toString());
        }
        return clientsRepo.findById(clientId).get();
    }

    @Override
    public Collection<Client> findAllClients() throws Exception {
        if(clientsRepo.findAll().isEmpty()){
            throw new Exception("No clients found.");
        }
        return clientsRepo.findAll().get();
    }

    @Override
    public Client saveNewClient(CreateClientRequest request) {
        Client client = new Client();
        client.setId(request.getId());
        client.setClientName(request.getClientName());
        return clientsRepo.save(client);
    }

    @Override
    public Client deleteClient(DeleteClientRequest request) throws Exception {
        if(clientsRepo.findById(request.getId()).isEmpty()){
            throw new Exception("No client found with ID: " + request.getId());
        }
        return clientsRepo.delete(clientsRepo.findById(request.getId()).get());
    }

    @Override
    public Client editClient(Long clientId, String newClientName) throws Exception {
        if(clientsRepo.findById(clientId).isEmpty()){
            throw new Exception("No client found with ID: " + clientId.toString());
        }
        Client client = clientsRepo.findById(clientId).get();
        client.setClientName(newClientName);
        return clientsRepo.save(client);
    }
    
}

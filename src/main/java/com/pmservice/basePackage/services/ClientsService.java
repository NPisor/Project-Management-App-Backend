package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Client.Client;
import com.pmservice.basePackage.models.Client.CreateClientRequest;
import com.pmservice.basePackage.models.Client.DeleteClientRequest;


public interface ClientsService {

    Client findClientById(Long clientId);

    Collection<Client> findAllClients();

    Client saveNewClient(CreateClientRequest request);

    Client deleteClient(DeleteClientRequest request);

    Client editClient(Long clientId, String newClientName);
    
}

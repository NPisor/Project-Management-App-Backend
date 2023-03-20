package com.pmservice.basePackage.services;

import java.util.Collection;

import com.pmservice.basePackage.models.Client.Client;
import com.pmservice.basePackage.models.Client.CreateClientRequest;
import com.pmservice.basePackage.models.Client.DeleteClientRequest;


public interface ClientsService {

    Client findClientById(Long clientId) throws Exception;

    Collection<Client> findAllClients() throws Exception;

    Client saveNewClient(CreateClientRequest request);

    Client deleteClient(DeleteClientRequest request) throws Exception;

    Client editClient(Long clientId, String newClientName) throws Exception;
    
}

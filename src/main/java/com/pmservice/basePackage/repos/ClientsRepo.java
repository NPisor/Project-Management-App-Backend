package com.pmservice.basePackage.repos;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Client.Client;

public interface ClientsRepo extends Repository<Client, Long> {

    Client findById(Long clientId);

    Collection<Client> findAll();

    Client save(Client client);

    Client delete(Client client);

}

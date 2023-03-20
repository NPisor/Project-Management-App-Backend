package com.pmservice.basePackage.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.pmservice.basePackage.models.Client.Client;

public interface ClientsRepo extends Repository<Client, Long> {

    Optional<Client> findById(Long clientId);

    Optional<Client> findByClientName(String clientName);

    Optional<Collection<Client>> findAll();

    Client save(Client client);

    Client delete(Client client);

}

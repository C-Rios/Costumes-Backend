package com.mintic.reto3ciclo3.repository;

import com.mintic.reto3ciclo3.model.Client;
import com.mintic.reto3ciclo3.repository.repositories.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getClients(){
        return (List<Client>) clientCrudRepository.findAll();
    }
}

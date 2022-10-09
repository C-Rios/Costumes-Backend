package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.Client;
import com.mintic.reto3ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return (List<Client>) clientRepository.getClients();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getId()==null)
            return clientRepository.save(client);
        else{
            Optional<Client> e = clientRepository.getClient(client.getId());

            if(e.isEmpty())
                return clientRepository.save(client);
            else
                return client;
        }
    }

    public Client update(Client client){
        if(client.getId()!=null){
            Optional<Client> e = clientRepository.getClient(client.getId());

            if(!e.isEmpty()){
                if(client.getMessages()!=null)
                    e.get().setMessages(client.getMessages());
                if(client.getAge()!=null)
                    e.get().setAge(client.getAge());
                if(client.getName()!=null)
                    e.get().setName(client.getName());
                if(client.getEmail()!=null)
                    e.get().setEmail(client.getEmail());
                if(client.getPassword()!=null)
                    e.get().setPassword(client.getPassword());
                if(client.getReservations()!=null)
                    e.get().setReservations(client.getReservations());

                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(int id){
        return getClient(id).map(client -> {
           clientRepository.delete(client);
           return true;
        }).orElse(false);
    }
}

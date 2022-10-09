package com.mintic.reto3ciclo3.controller;

import com.mintic.reto3ciclo3.model.Client;
import com.mintic.reto3ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/update")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return clientService.delete(id);
    }
}

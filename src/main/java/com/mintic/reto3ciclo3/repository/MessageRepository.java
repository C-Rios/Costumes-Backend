package com.mintic.reto3ciclo3.repository;

import com.mintic.reto3ciclo3.model.Messages;
import com.mintic.reto3ciclo3.repository.repositories.MessagesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessagesCrudRepository messagesCrudRepository;

    public List<Messages> getMessages(){
        return (List<Messages>) messagesCrudRepository.findAll();
    }

    public Optional<Messages> getMessage(int id){
        return messagesCrudRepository.findById(id);
    }

    public Messages save(Messages messages){
        return messagesCrudRepository.save(messages);
    }

    public void delete(Messages messages){
        messagesCrudRepository.delete(messages);
    }
}

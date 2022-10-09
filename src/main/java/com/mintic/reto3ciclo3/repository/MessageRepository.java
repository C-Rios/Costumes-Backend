package com.mintic.reto3ciclo3.repository;

import com.mintic.reto3ciclo3.model.Message;
import com.mintic.reto3ciclo3.repository.repositories.MessagesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessagesCrudRepository messagesCrudRepository;

    public List<Message> getMessages(){
        return (List<Message>) messagesCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messagesCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messagesCrudRepository.save(message);
    }

    public void delete(Message message){
        messagesCrudRepository.delete(message);
    }
}

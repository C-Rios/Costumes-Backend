package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.Message;
import com.mintic.reto3ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getMessages();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getId()==null){
            //|| message.getClient() ==null || message.getCostume() ==null
            if(message.getText()==null){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }else{
            Optional<Message> e = messageRepository.getMessage(message.getId());

            if(e.isEmpty())
                return messageRepository.save(message);
            else
                return message;
        }
    }

    public Message update(Message message){
        if(message.getId()!=null){
            Optional<Message> e = messageRepository.getMessage(message.getId());
            if(!e.isEmpty()){
                if(message.getClient()!=null)
                    e.get().setClient(message.getClient());
                if(message.getText()!=null)
                    e.get().setText(message.getText());
                if(message.getCostume()!=null)
                    e.get().setCostume(message.getCostume());

                messageRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else
            return message;
    }

    public boolean delete(int id){
        Boolean gotDeleted =  getMessage(id).map(message -> {
           messageRepository.delete(message);
           return true;
        }).orElse(false);
        return gotDeleted;
    }
}

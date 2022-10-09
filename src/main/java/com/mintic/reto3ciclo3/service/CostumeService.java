package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.Costume;
import com.mintic.reto3ciclo3.repository.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeService {
    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll(){
        return costumeRepository.getAll();
    }
    public Optional<Costume> getCostume(int id){
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume costume){
        if(costume.getId()==null){
            return costumeRepository.save(costume);
        }else{
            //Verifica que el ya existe un objeto con este id
            Optional<Costume> e = costumeRepository.getCostume(costume.getId());
            //Si no lo encuentra, lo guarda con normalidad
            if(e.isEmpty())
                return costumeRepository.save(costume);
            else
                //Si lo encuentra, no almacena nada y devuelve los datos ingresados
                return costume;
        }
    }

    public Costume update(Costume costume){
        if(costume.getId()!=null){
            Optional<Costume> e = costumeRepository.getCostume(costume.getId());
            if(!e.isEmpty()){
                if(costume.getName()!=null){
                    e.get().setName(costume.getName());
                }
                if(costume.getBrand()!=null){
                    e.get().setBrand(costume.getBrand());
                }
                if(costume.getDate()!=null){
                    e.get().setDate(costume.getDate());
                }
                if(costume.getDescription()!=null){
                    e.get().setDescription(costume.getDescription());
                }
                if(costume.getCategory()!=null){
                    e.get().setCategory(costume.getCategory());
                }

                costumeRepository.save(e.get());
                return e.get();
            }else{
                return costume;
            }
        }else {
            return costume;
        }
    }

    public boolean delete(int id){
        Boolean gotDeleted = getCostume(id).map(costume -> {
            costumeRepository.delete(costume);
            return true;
        }).orElse(false);
        return gotDeleted;
    }
}

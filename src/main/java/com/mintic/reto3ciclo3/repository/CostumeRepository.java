package com.mintic.reto3ciclo3.repository;

import com.mintic.reto3ciclo3.model.Costume;
import com.mintic.reto3ciclo3.repository.repositories.CostumeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CostumeRepository {
    @Autowired
    private CostumeCrudRepository costumeCRUDrespository;

    public List<Costume> getAll(){
        return (List<Costume>) costumeCRUDrespository.findAll();
    }

    public Optional<Costume> getCostume(int id){
        return costumeCRUDrespository.findById(id);
    }

    public Costume save(Costume costume){
        return costumeCRUDrespository.save(costume);
    }

    public void delete(Costume costume){
        costumeCRUDrespository.delete(costume);
    }
}

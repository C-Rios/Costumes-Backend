package com.mintic.reto3ciclo3.controller;

import com.mintic.reto3ciclo3.model.Costume;
import com.mintic.reto3ciclo3.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/costume")
public class CostumeController {
    @Autowired
    private CostumeService costumeService;

    @GetMapping("/all")
    public List<Costume> getCostumes(){
        return costumeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int costumeId){
        return costumeService.getCostume(costumeId);
    }

    @PostMapping("/save")
    public Costume save(@RequestBody Costume costume){
        return costumeService.save(costume);
    }

    @PutMapping("/update")
    public Costume update(@RequestBody Costume costume){
        return costumeService.update(costume);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int costumeID){
        return costumeService.delete(costumeID);
    }
}

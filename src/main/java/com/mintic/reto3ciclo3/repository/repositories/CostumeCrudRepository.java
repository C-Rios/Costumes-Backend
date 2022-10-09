package com.mintic.reto3ciclo3.repository.repositories;

import com.mintic.reto3ciclo3.model.Costume;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostumeCrudRepository extends CrudRepository<Costume, Integer> {

    //@Query("SELECT c.date, COUNT(c.date) FROM Costume AS c GROUP BY c.date ORDER BY COUNT(c.date) DESC")
    //public List<Object[]> countTotalCostumesByYear;
}

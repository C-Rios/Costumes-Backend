package com.mintic.reto3ciclo3.repository;

import com.mintic.reto3ciclo3.model.AdminUser;
import com.mintic.reto3ciclo3.repository.repositories.AdminUserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminUserRepository {
    @Autowired
    private AdminUserCrudRepository adminUserCrudRepository;

    public List<AdminUser> getAdmins(){
        return (List<AdminUser>) adminUserCrudRepository.findAll();
    }

    public Optional<AdminUser> getAdmin(int id ){
        return adminUserCrudRepository.findById(id);
    }

    public AdminUser save(AdminUser adminUser){
        return adminUserCrudRepository.save(adminUser);
    }

    public void delete(AdminUser adminUser){
        adminUserCrudRepository.delete(adminUser);
    }
}

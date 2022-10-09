package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.AdminUser;
import com.mintic.reto3ciclo3.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;

    public List<AdminUser> getAll(){
        return adminUserRepository.getAdmins();
    }

    public Optional<AdminUser> getAdmin(int id){
        return adminUserRepository.getAdmin(id);
    }

    public AdminUser save(AdminUser adminUser){
        if(adminUser.getId()==null)
            return adminUserRepository.save(adminUser);
        else{
            Optional<AdminUser> e = adminUserRepository.getAdmin(adminUser.getId());
            if(e.isEmpty())
                return adminUserRepository.save(adminUser);
            else
                return adminUser;
        }
    }

    public AdminUser update(AdminUser adminUser){
        if(adminUser.getId()!=null){
            Optional<AdminUser> e = adminUserRepository.getAdmin(adminUser.getId());
            if(!e.isEmpty()){
                if(adminUser.getName()!=null)
                    e.get().setName(adminUser.getName());
                if(adminUser.getEmail()!=null)
                    e.get().setEmail(adminUser.getEmail());
                if(adminUser.getPassword()!=null)
                    e.get().setPassword(adminUser.getPassword());

                adminUserRepository.save(e.get());
                return e.get();
            }else
                return adminUser;
        }else
            return adminUser;
    }

    public boolean delete(int id){
        return getAdmin(id).map(adminUser -> {
            adminUserRepository.delete(adminUser);
            return true;
        }).orElse(false);
    }
}

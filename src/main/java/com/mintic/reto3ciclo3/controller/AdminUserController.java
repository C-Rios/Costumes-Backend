package com.mintic.reto3ciclo3.controller;

import com.mintic.reto3ciclo3.model.AdminUser;
import com.mintic.reto3ciclo3.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/all")
    public List<AdminUser> getAll(){
        return adminUserService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AdminUser> getAdmin(@PathVariable("id")int id){
        return adminUserService.getAdmin(id);
    }

    @PostMapping("/save")
    public AdminUser save(@RequestBody AdminUser adminUser){
        return adminUserService.save(adminUser);
    }

    @PutMapping("/update")
    public AdminUser update(@RequestBody AdminUser adminUser){
        return adminUserService.update(adminUser);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return adminUserService.delete(id);
    }
}

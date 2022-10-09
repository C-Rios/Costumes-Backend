package com.mintic.reto3ciclo3.controller;

import com.mintic.reto3ciclo3.model.Category;
import com.mintic.reto3ciclo3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }
}

package com.mintic.reto3ciclo3.service;

import com.mintic.reto3ciclo3.model.Category;
import com.mintic.reto3ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryRepository.getCategories();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null)
            return categoryRepository.save(category);
        else{
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(e.isEmpty())
                return categoryRepository.save(category);
            else
                return category;
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(!e.isEmpty()){
                if(category.getCostumes()!=null)
                    e.get().setCostumes(category.getCostumes());
                if(category.getDescription()!=null)
                    e.get().setDescription(category.getDescription());
                if(category.getName()!=null)
                    e.get().setName(category.getName());

                categoryRepository.save(e.get());
                return e.get();
            }else {
                return category;
            }
        }else{
            return category;
        }
    }

    public boolean delete(int id){
        return getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
    }
}

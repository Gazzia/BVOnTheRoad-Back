package com.breizhvideo.ontheroad.controller;

import com.breizhvideo.ontheroad.model.Category;
import com.breizhvideo.ontheroad.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.listCategories();
    }

    @GetMapping("/categories/{id}")
    ResponseEntity<Category> getCategoryById(@PathVariable(value="id") long id) {
        Optional<Category> category = categoryService.getCategory(id);
        if (category.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category.get());
    }

    @PostMapping("/categories")
    public Category postCategory(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable(value="id") long id){
        categoryService.deleteCategory(id);
    }

}

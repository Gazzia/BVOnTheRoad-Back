package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Category;
import com.breizhvideo.ontheroad.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> listCategories() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category insertCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> optionalCategory = this.getCategory(id);
        if(optionalCategory.isPresent()) {
            return repository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> category = this.getCategory(id);
        category.ifPresent(value -> repository.delete(value));
    }
}
package com.breizhvideo.ontheroad.service;

import com.breizhvideo.ontheroad.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface CategoryService {
    List<Category> listCategories();
    Optional<Category> getCategory(Long id);
    Category insertCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}

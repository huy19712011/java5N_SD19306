package com.example.java5n_sd19306.service;

import com.example.java5n_sd19306.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Object getAllCategories() {

        return categoryRepository.findAll();
    }
}

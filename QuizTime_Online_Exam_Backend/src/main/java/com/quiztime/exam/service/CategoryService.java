package com.quiztime.exam.service;

import com.quiztime.exam.dto.CategoryRequest;
import com.quiztime.exam.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category createCategory(CategoryRequest request);

    Category updateCategory(Long id, CategoryRequest request);

    Category updateCategoryStatus(Long id, String status);

    void deleteCategory(Long id);
}

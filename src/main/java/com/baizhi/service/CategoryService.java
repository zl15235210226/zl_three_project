package com.baizhi.service;

import com.baizhi.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    void  saveCategory(Category category);
    void deleteCategory(Integer id);
}

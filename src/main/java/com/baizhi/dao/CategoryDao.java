package com.baizhi.dao;

import com.baizhi.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategory();
    //添加方法
    void saveCategory(Category category);
    //删除方法
    void deleteCategory(Integer id);
    //更新方法
    void updateCate(Category category);
}

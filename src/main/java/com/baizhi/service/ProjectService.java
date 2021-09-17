package com.baizhi.service;

import com.baizhi.entity.Product;

import java.util.List;

public interface ProjectService {
    List<Product> queryAllProduct(String name, String status, String phone, Integer start, Integer page);

    Long queryProductTotal(String name, String status, String phone);

    void upDate(Product product);

    void delete(Integer id);

    void add(Product product);
}

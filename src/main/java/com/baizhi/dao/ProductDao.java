package com.baizhi.dao;

import com.baizhi.entity.Product;

import java.util.List;

public interface ProductDao {

    /**
     * 查所有
     * @return
     */
    List<Product> findAllProduct();
}

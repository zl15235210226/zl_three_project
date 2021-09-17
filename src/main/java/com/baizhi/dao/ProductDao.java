package com.baizhi.dao;

import com.baizhi.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    List<Product> queryAllProduct(@Param("name") String name, @Param("status") String status, @Param("phone") String phone, @Param("start") Integer start, @Param("number") Integer page);

    Long queryProductTotal(@Param("name") String name, @Param("status") String status, @Param("phone") String phone);

    void upDate(Product product);

    void delete(Integer id);

    void add(Product product);
}

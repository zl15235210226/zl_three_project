package com.baizhi.service;

import com.baizhi.dao.ProductDao;
import com.baizhi.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProductDao productDao;
    //开启事务
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> findAllProduct() {

        return productDao.findAllProduct();
    }
}

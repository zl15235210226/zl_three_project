package com.baizhi.service;

import com.baizhi.dao.ProductDao;
import com.baizhi.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProductDao productDao;


    @Override
    public List<Product> queryAllProduct(String name, String status, String phone, Integer start, Integer page) {
        if (name!=null)  name = "%"+name+"%";
        if (status!=null)  status = "%"+status+"%";
        if (phone!=null) phone = "%"+phone+"%";

        return productDao.queryAllProduct(name,status,phone,start,page);
    }

    @Override
    public Long queryProductTotal(String name, String status, String phone) {
        if (name!=null)  name = "%"+name+"%";
        if (status!=null)  status = "%"+status+"%";
        if (phone!=null) phone = "%"+phone+"%";
        return productDao.queryProductTotal(name,status,phone);
    }

    @Override
    public void upDate(Product product) {
        productDao.upDate(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);

    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }
}

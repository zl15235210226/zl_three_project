package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAllUser(Integer page, Integer rows,String ftype , String value) {
        String phone=null;String name=null;String status=null;
        if (ftype.equals("phone")){ phone = "%"+value+"%";}
        if (ftype.equals("name")){ name = "%"+value+"%";}
        if (ftype.equals("status")){ status= "%"+value+"%";}

        int start = (page - 1) * rows;
        return userDao.findAllUser(start,rows,phone,name,status);

    }

    @Override
    public Long findUserTotal(String ftype , String value) {
        String phone=null;String name=null;String status=null;
        if (ftype.equals("phone")){ phone = "%"+value+"%";}
        if (ftype.equals("name")){ name = "%"+value+"%";}
        if (ftype.equals("status")){ status= "%"+value+"%";}
        System.out.println(phone);
        System.out.println(userDao.findUserTotal(phone,name,status));
        return userDao.findUserTotal(phone,name,status);
    }

    @Override
    public void delUser(Integer id) {
        userDao.delUser(id);
    }

    @Override
    public void updUser(User user) {
        userDao.updUser(user);
    }


}

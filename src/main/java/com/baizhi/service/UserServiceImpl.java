package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAllUser(Integer page, Integer rows) {
        int start = (page - 1) * rows;
        return userDao.findAllUser(start, rows);
    }

    @Override
    public Long findUserTotal() {
        return userDao.findUserTotal();
    }
}

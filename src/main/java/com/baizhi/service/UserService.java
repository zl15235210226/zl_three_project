package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
        List<User> findAllUser(Integer page, Integer rows,String ftype,String value);

        Long findUserTotal(String ftype,String value);

        void delUser(Integer id);

        void updUser(User user);


        }


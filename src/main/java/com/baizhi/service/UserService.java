package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser(Integer page, Integer rows);
    Long findUserTotal();
}


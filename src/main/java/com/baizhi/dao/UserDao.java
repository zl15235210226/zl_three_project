package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUser(Integer start, Integer rows);

    Long findUserTotal();

}

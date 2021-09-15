package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {
    List<User> findAllUser(@Param("start") Integer start, @Param("rows")Integer rows, @Param("phone")String phone , @Param("name")String name, @Param("status")String status);

    Long findUserTotal(@Param("phone")String phone , @Param("name")String name, @Param("status")String status);

    void delUser(Integer id);

    void updUser(User user);
}

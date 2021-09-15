package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("users")
    public Map<String, Object> findAllUser(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "3") Integer rows) {
        HashMap<String, Object> result = new HashMap<>();
        // 返回的分页后的对象
        List<User> users = userService.findAllUser(page, rows);
        Long total = userService.findUserTotal();
        result.put("total", total);
        result.put("users", users);
        return result;
    }
}

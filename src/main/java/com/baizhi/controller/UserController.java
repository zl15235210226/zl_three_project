package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Object> findAllUser(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "5") Integer rows,String ftype,String value) {
        HashMap<String, Object> result = new HashMap<>();

        // 返回的分页后的对象

        List<User> users = userService.findAllUser(page, rows,ftype,value);
        Long total = userService.findUserTotal(ftype,value);
        result.put("total", total);
        result.put("users", users);
        return result;
    }


    /**
     * 删除用户
     */
    @DeleteMapping("/userdelete/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userService.delUser(id);
    }


    /**
     * 修改用户状态
     */
    @PostMapping("/userupdate")
    public void updUser(@RequestBody User user){
        userService.updUser(user);
    }




}

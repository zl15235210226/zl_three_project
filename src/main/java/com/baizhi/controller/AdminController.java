package com.baizhi.controller;



import com.baizhi.constants.RedisPrefix;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.utils.ValidateCodeUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
@RestController
@CrossOrigin

public class AdminController {

    @Resource
    private  AdminService adminService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> map){
    //接受前端传递的参数
        String username=map.get("username");
        String password=map.get("password");
        String code= map.get("code");
        String token=map.get("token");
    //请求返回的结果
        HashMap<String,Object> result=new HashMap<>();

        try {

            //判断参数是否合法
            //获取redis中的验证码
            String redisCode = stringRedisTemplate.opsForValue().get(RedisPrefix.CAPTCHA_CODE + token);
            System.out.println(code + "=======" + redisCode);
            // 比对验证码是否一致 判断验证码是否正确
            if (redisCode == null) throw new RuntimeException("验证码已过期");
            if (!redisCode.equalsIgnoreCase(code)) throw new RuntimeException("您输入的验证码不一致");
            // TODO 根据用户名密码 到数据库中进行查询
            Admin admin = adminService.getAdmin(new Admin(null, username, password, null));
            //将用户保存到redis中
            stringRedisTemplate.opsForValue().set(RedisPrefix.USER_LOGIN + token, username, 30, TimeUnit.MINUTES);
            result.put("success", true);
            result.put("username", admin.getUsername());
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        //返回登录成功与否
        return  result;
    }
    /**
     * 为前端返回字符验证码
     * @return
     */
    @GetMapping("/captcha")
    public Map<String,String> captcha(){
        //防御验证码
        HashMap <String,String> hashMap = new HashMap<>();
        //为每个验证码生成一个唯一的key
        String token= DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
        System.out.println(token);
        //生成value字符串的值
        ValidateCodeUtil.Validate validate =ValidateCodeUtil.getRandomCode();
        String value = validate.getValue();
        System.out.println("value = " + value);
        //将验证码保存到redis中

        stringRedisTemplate.opsForValue().set(RedisPrefix.CAPTCHA_CODE + token, value, 10, TimeUnit.MINUTES);
        //生成base64
        String base64Str =validate.getBase64Str();
        //返回base64
        hashMap.put("code", "data:image/png;base64," + base64Str);
        hashMap.put("token", token);
        return hashMap;

        /**
         * 验证用户登录状态
         * 通过token 获取对应的用户名  比对用户名
         */

        /**
         * 退出登录
         * 删除redis中保存的用户登录状态 LOGIN+TOKEN
         */
    }
}

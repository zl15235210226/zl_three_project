package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.utils.Md5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService{
    @Resource
    private AdminDao adminDao;

    @Override
    public Admin getAdmin(Admin admin) {
        Admin  dbAdmin= adminDao.getAdmin(admin);
        String salt=dbAdmin.getSalt();
        //获取用户输入的明文密码
        String userPwd = admin.getPassword();
        if (dbAdmin!=null){
            if (Md5Utils.getMd5Code(userPwd+salt).equals(dbAdmin.getPassword())){
                return dbAdmin;
            }
            throw  new RuntimeException("密码不一致");
        }
        throw new RuntimeException("用户不存在");
    }

}

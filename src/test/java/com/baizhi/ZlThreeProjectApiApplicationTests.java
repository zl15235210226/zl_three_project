package com.baizhi;

import com.baizhi.dao.CategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ZlThreeProjectApiApplicationTests {

    @Resource
    private CategoryDao categoryDao;
    @Test
    void contextLoads() {
        categoryDao.deleteCategory(8);
        System.out.println("删除成功");
    }

}

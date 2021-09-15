package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 类别列表
     * @return
     */
    @GetMapping("/categorys")
    public List<Category>  findAllCategory(){
        return categoryService.findAllCategory();
    }

    /**
     * 添加类型
     * @param category
     * @return
     */
    @PostMapping("/categorys")
    public Map<String,Object> addCategory(@RequestBody Category category) {

        System.out.println(category);
        HashMap<String,Object> map =new HashMap<>();
        try {
            categoryService.saveCategory(category);
            map.put("success",true);
            map.put("msg","添加信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","添加信息失败:"+e.getMessage());
        }
        return  map;

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public  Map<String,Object> delete(@PathVariable("id") Integer id) {
        System.out.println(id+"+++++++++");

        HashMap<String,Object> map=new HashMap<>();
        try {
            categoryService.deleteCategory(id);
            map.put("success",true);
            map.put("msg","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除失败"+e.getMessage());
        }
        return map;
    }
     @PutMapping("/update")
    public void update(@RequestBody Category category){
        categoryService.updateCategpryController(category);
     }
}

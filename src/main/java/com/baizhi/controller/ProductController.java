package com.baizhi.controller;

import com.baizhi.constants.UploadPrefix;
import com.baizhi.entity.Product;
import com.baizhi.service.ProjectService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin
public class ProductController {

    @Resource
    private ProjectService projectService;

    //将工厂中的属性进行注入
    @Value("${upload.dir}")
    private String realPath;


    /**
     * 课程列表
     * @return 所有课程的集合
     */
    /**
     * 课程列表
     *
     * @return 所有课程的集合
     */
    @GetMapping("QueryAllProduct")
    public Map<String, Object> queryAllProduct(@RequestParam Integer start, @RequestParam Integer page) {
        start = (start - 1) *  page;
        HashMap<String, Object> result = new HashMap<>();
        // 返回的分页后的对象
        List<Product> users = projectService.queryAllProduct(null,null,null,start, page);
        Long total = projectService.queryProductTotal(null,null,null);
        result.put("total", total);
        result.put("users", users);

        return result;
    }

    /**
     * 上传课程图片
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {

       // System.out.println(realPath);
       //创建日期目录
        String dateString = LocalDate.now().toString();
        File dateDir = new File(realPath, dateString);
        if (!dateDir.exists()) dateDir.mkdirs();

        //处理上传文件名称
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;

        //处理文件上传
            file.transferTo(new File(dateDir,newFileName));
        // 返回文件上传后的服务器全路径  http://localhost:8989/admin/2021-09-16/68b0e29c296d495f9b1891d21d8c0810.jpg
       return UploadPrefix.IMG_URL + dateString + "/" + newFileName;
    }
    /**
     * 保存课程对象
     */
    @PostMapping("SaveProduct")
    public void saveProduct(@RequestBody Product product) {
        System.out.println(product);
        product.setPubDate(new Date());
        projectService.add(product);

        // 调用service 将 课程保存到数据库即可
    }

    /**
     * 删除课程
     */
    @DeleteMapping("DeleteProduct/{id}")
    public String delete(@PathVariable("id") Integer id) {
        projectService.delete(id);

        return "OK";
    }

    /**
     * 修改课程
     */
    @PostMapping("UpdateProduct")
    public String update(@RequestParam Integer id,@RequestParam String name){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        System.out.println(id);
        System.out.println(name);
        projectService.upDate(product);
        return "ok";
    }

}

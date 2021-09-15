package com.baizhi.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Date bir;
    private String password;
    private String image;
    private Integer status;
    private String phone;

    public User() {
    }

    public User(Integer id, String name, Integer age, Date bir, String password, String image, Integer status, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.password = password;
        this.image = image;
        this.status = status;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                '}';
    }
}

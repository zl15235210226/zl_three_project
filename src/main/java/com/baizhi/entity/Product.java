package com.baizhi.entity;

import java.util.Date;
import java.util.Objects;

public class Product {

    private Integer id;
    private String name;
    private String courseImg;      // 课程图片
    private Integer courseType;     // 课程收费与否
    private String brief;      // 课程详情
    private String level;      // 课程难度等级
    private Date pubDate;      // 课程的发布日期
    private Integer period;     // 课程建议的学习周期
    private Integer status;     // 课程的状态  上架  下架 售罄
    private Integer students;   // 课程报名学习的人数
    private Integer lessons;    // 课程总课时
    private Integer pubLessons;    // 课程已更新课时
    private Double price;       // 课程价格
    private Integer courseCategoryId;   // 课程所属的类别
    private Integer teacherId;      // 课程的讲师id
    private Category category;
    private Teacher teacher;

    public Product(Integer id, String name, String courseImg, Integer courseType, String brief, String level, Date pubDate, Integer period, Integer status, Integer students, Integer lessons, Integer pubLessons, Double price, Integer courseCategoryId, Integer teacherId, Category category, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.courseImg = courseImg;
        this.courseType = courseType;
        this.brief = brief;
        this.level = level;
        this.pubDate = pubDate;
        this.period = period;
        this.status = status;
        this.students = students;
        this.lessons = lessons;
        this.pubLessons = pubLessons;
        this.price = price;
        this.courseCategoryId = courseCategoryId;
        this.teacherId = teacherId;
        this.category = category;
        this.teacher = teacher;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(courseImg, product.courseImg) && Objects.equals(courseType, product.courseType) && Objects.equals(brief, product.brief) && Objects.equals(level, product.level) && Objects.equals(pubDate, product.pubDate) && Objects.equals(period, product.period) && Objects.equals(status, product.status) && Objects.equals(students, product.students) && Objects.equals(lessons, product.lessons) && Objects.equals(pubLessons, product.pubLessons) && Objects.equals(price, product.price) && Objects.equals(courseCategoryId, product.courseCategoryId) && Objects.equals(teacherId, product.teacherId) && Objects.equals(category, product.category) && Objects.equals(teacher, product.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, courseImg, courseType, brief, level, pubDate, period, status, students, lessons, pubLessons, price, courseCategoryId, teacherId, category, teacher);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseImg='" + courseImg + '\'' +
                ", courseType=" + courseType +
                ", brief='" + brief + '\'' +
                ", level='" + level + '\'' +
                ", pubDate=" + pubDate +
                ", period=" + period +
                ", status=" + status +
                ", students=" + students +
                ", lessons=" + lessons +
                ", pubLessons=" + pubLessons +
                ", price=" + price +
                ", courseCategoryId=" + courseCategoryId +
                ", teacherId=" + teacherId +
                ", category=" + category +
                ", teacher=" + teacher +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }

    public Integer getLessons() {
        return lessons;
    }

    public void setLessons(Integer lessons) {
        this.lessons = lessons;
    }

    public Integer getPubLessons() {
        return pubLessons;
    }

    public void setPubLessons(Integer pubLessons) {
        this.pubLessons = pubLessons;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Integer courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}


package com.baizhi.entity;

public class Teatcher {;
  private    Integer id;
  private    Integer        is_show;
  private    Integer orders;
  private     Integer         is_delete;
  private     String name;
  private     Integer        role;
  private    String title;
  private    String        signature;
  private     String image;
  private    Integer       brief;

    public Teatcher() {
    }

    public Teatcher(Integer id, Integer is_show, Integer orders, Integer is_delete, String name, Integer role, String title, String signature, String image, Integer brief) {
        this.id = id;
        this.is_show = is_show;
        this.orders = orders;
        this.is_delete = is_delete;
        this.name = name;
        this.role = role;
        this.title = title;
        this.signature = signature;
        this.image = image;
        this.brief = brief;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIs_show() {
        return is_show;
    }

    public void setIs_show(Integer is_show) {
        this.is_show = is_show;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getBrief() {
        return brief;
    }

    public void setBrief(Integer brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "Teatcher{" +
                "id=" + id +
                ", is_show=" + is_show +
                ", orders=" + orders +
                ", is_delete=" + is_delete +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", title='" + title + '\'' +
                ", signature='" + signature + '\'' +
                ", image='" + image + '\'' +
                ", brief=" + brief +
                '}';
    }
}

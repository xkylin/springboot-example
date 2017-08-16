package com.github.springboot.example.entities;

import java.util.Date;

public class User {
    private Long id;

    private String name;

    private Integer age;

    private Integer status;

    private Date createTime;

    private boolean isOnlyActive;

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isOnlyActive() {
        return isOnlyActive;
    }

    public void setOnlyActive(boolean onlyActive) {
        isOnlyActive = onlyActive;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserName:" + this.getName() + ",Age:" + this.getAge();
    }
}

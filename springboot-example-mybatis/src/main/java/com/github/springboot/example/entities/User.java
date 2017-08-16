package com.github.springboot.example.entities;

public class User {
    private Long id;

    private String name;

    private Integer age;

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

    @Override
    public String toString() {
        return "UserName:" + this.getName() + ",Age:" + this.getAge();
    }
}

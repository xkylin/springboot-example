package com.github.springboot.example.repository;

import com.github.springboot.example.entities.User;

import java.util.List;

public interface UserMapper {

    public void insert(User user);

    public List<User> selectAll();
}

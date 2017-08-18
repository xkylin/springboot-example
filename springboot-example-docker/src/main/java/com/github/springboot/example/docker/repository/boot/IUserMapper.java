package com.github.springboot.example.docker.repository.boot;

import com.github.springboot.example.docker.entities.User;

import java.util.List;

public interface IUserMapper {

    public int insert(User user);

    public int delete(User user);

    public int update(User user);

    public User selectById(Long id);

    public List<User> selectAll();

    public List<User> selectAllByCondition(User user);
}

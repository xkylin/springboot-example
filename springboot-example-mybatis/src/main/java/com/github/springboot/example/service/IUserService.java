package com.github.springboot.example.service;

import com.github.springboot.example.entities.User;

import java.util.List;

/**
 * 用户业务接口定义
 */
public interface IUserService {
    /**
     * 添加用户
     * @param user 用户实体
     * @return 新增操作数据条数
     */
    public int add(User user);

    public List<User> fetchUsers();

    public List<User> fetchUsers(User user);

    public User fetchUser(String id);
}

package com.github.springboot.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.springboot.example.entities.User;
import com.github.springboot.example.repository.IUserMapper;
import com.github.springboot.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public int add(User user) {
        return this.userMapper.insert(user);
    }

    @Override
    public List<User> fetchUsers() {
        PageHelper.startPage(1, 10);
        return this.userMapper.selectAll();
    }

    @Override
    public List<User> fetchUsers(User user) {
        return this.userMapper.selectAllByCondition(user);
    }

    @Override
    public User fetchUser(String id) {
        return this.userMapper.selectById(Long.parseLong(id));
    }
}

package com.github.springboot.example.service.impl;

import com.github.springboot.example.entities.User;
import com.github.springboot.example.repository.IUserMapper;
import com.github.springboot.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public int add(User user) {
        return this.userMapper.insert(user);
    }
}

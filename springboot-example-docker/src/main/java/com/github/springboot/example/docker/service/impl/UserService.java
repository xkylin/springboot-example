package com.github.springboot.example.docker.service.impl;

import com.github.springboot.example.docker.entities.User;
import com.github.springboot.example.docker.repository.boot.IUserMapper;
import com.github.springboot.example.docker.service.IUserServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserServive {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User fetchUserById(Long id) {
        return this.userMapper.selectById(id);
    }
}

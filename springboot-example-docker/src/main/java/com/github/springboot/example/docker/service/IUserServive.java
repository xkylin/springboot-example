package com.github.springboot.example.docker.service;

import com.github.springboot.example.docker.entities.User;

public interface IUserServive {

    public User fetchUserById(Long id);
}

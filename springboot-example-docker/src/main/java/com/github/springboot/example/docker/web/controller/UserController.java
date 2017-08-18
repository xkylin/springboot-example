package com.github.springboot.example.docker.web.controller;

import com.github.springboot.example.docker.entities.User;
import com.github.springboot.example.docker.service.IUserServive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserServive userServive;

    @RequestMapping(value = "/hello")
    public String hello() {
        this.logger.info("Hello 方法");
        return "Hello Eugene!";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public User info() {
        this.logger.info("Info 方法");
        return new User(1L, "Eugene", 24);
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/query/{id}")
    public User queryUserById(@PathVariable String id) {
        return this.userServive.fetchUserById(Long.parseLong(id));
    }
}

package com.github.springboot.example.web.controller;

import com.github.springboot.example.entities.User;
import com.github.springboot.example.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/hello")
    public String hello() {
        this.logger.info("Hello 方法");
        return "Hello Eugene!";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public List<User> info() {
        this.logger.info("Info 方法");
        return this.userService.fetchUsers();
    }

    @RequestMapping(value = "/info/{id}")
    @ResponseBody
    public User info(@PathVariable String id) {
        return this.userService.fetchUser(id);
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }
}

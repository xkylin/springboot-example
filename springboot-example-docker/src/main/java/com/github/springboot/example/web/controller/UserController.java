package com.github.springboot.example.web.controller;

import com.github.springboot.example.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/hello")
    public String hello() {
        this.logger.info("Hello 方法");
        return "Hello Eugene!";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public User info() {
        this.logger.info("Info 方法");
        return new User(1L, "Eugene", "24");
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }
}

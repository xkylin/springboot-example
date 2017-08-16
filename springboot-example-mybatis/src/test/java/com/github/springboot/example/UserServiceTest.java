package com.github.springboot.example;

import com.github.springboot.example.entities.User;
import com.github.springboot.example.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Test");
        user.setAge(110);
        int count = this.userService.add(user);
        Assert.assertEquals(1, count);
    }
}

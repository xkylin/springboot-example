package com.github.springboot.example;

import com.github.pagehelper.PageHelper;
import com.github.springboot.example.entities.User;
import com.github.springboot.example.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/*
	@SpringBootConfiguration说明这是一个配置文件类，
	它会被@ComponentScan扫描到
 */
//@SpringBootConfiguration
/*
	@SpringBootApplication一个组合注解，
	包括@EnableAutoConfiguration及其他多个注解，是一个项目的启动注解
 */
@SpringBootApplication
public class UserMapperTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() {
		User user = new User();
		user.setName("King");
		user.setAge(18);
		this.userMapper.insert(user);
	}

	@Test
	public void testSelectAll() {
		PageHelper.startPage(1, 1);
		List<User> users = this.userMapper.selectAll();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + users.get(0));
	}

}

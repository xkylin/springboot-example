package com.github.springboot.example;

import com.github.pagehelper.PageHelper;
import com.github.springboot.example.entities.User;
import com.github.springboot.example.repository.boot.IUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
	private IUserMapper IUserMapper;

	@Test
	public void testInsert() {
		User user = new User();
		user.setName("Susan");
		user.setAge(18);
		int count = this.IUserMapper.insert(user);
		Assert.assertEquals(1, count);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(3L);
		user.setName("test");
//		user.setAge(60);
		int count = this.IUserMapper.update(user);
		Assert.assertEquals(1, count);
		user.setId(100L);
		count = this.IUserMapper.update(user);
		Assert.assertEquals(0, count);
	}

	@Test
	public void testSelectAll() {
		PageHelper.startPage(1, 10);
		List<User> users = this.IUserMapper.selectAll();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + users.size());

		User user = new User();
		user.setAge(18);
		user.setOnlyActive(true);
		users = this.IUserMapper.selectAllByCondition(user);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + users.size());

	}

}

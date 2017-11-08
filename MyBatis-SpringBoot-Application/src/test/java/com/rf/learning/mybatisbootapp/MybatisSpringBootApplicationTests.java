package com.rf.learning.mybatisbootapp;

import com.rf.learning.mybatisbootapp.domain.User;
import com.rf.learning.mybatisbootapp.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest("MybatisSpringBootApplication")
public class MybatisSpringBootApplicationTests
{
	public static final String EMAIL = "johnson@gmail.com";
	public static final String NAME = "Johnson";

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAllUsers()
	{
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById()
	{
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser()
	{
		User user = new User(0, NAME, EMAIL);
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertNotNull(newUser);
		assertEquals(NAME, newUser.getName());
		assertEquals(EMAIL, newUser.getEmail());
	}
}

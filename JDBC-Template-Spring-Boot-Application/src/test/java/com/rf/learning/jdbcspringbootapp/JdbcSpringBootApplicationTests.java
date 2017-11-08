package com.rf.learning.jdbcspringbootapp;

import com.rf.learning.jdbcspringbootapp.domain.User;
import com.rf.learning.jdbcspringbootapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest("JdbcSpringBootApplication")
public class JdbcSpringBootApplicationTests
{
  public static final String EMAIL = "johnson@gmail.com";
  public static final String NAME = "Johnson";

  @Autowired
  private UserRepository userRepository;

  @Test
  public void findAllUsers()
  {
    List<User> users = userRepository.findAll();
    assertNotNull(users);
    assertTrue(!users.isEmpty());
  }

  @Test
  public void findUserById()
  {
    User user = userRepository.findUserById(1);
    assertNotNull(user);
  }

  @Test
  public void createUser()
  {
    User user = new User(0, NAME, EMAIL);
    User savedUser = userRepository.create(user);
    User newUser = userRepository.findUserById(savedUser.getId());
    assertNotNull(newUser);
    assertEquals(NAME, newUser.getName());
    assertEquals(EMAIL, newUser.getEmail());
  }
}

package com.rf.learning.mongodbspringbootapp;

import com.rf.learning.mongodbspringbootapp.domain.User;
import com.rf.learning.mongodbspringbootapp.repository.UserRepository;
import com.rf.learning.mongodbspringbootapp.service.MongoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest("MongoDBSpringBootAppApplication")
public class MongoDBSpringBootAppApplicationTests
{
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MongoUserService mongoUserService;

  @Test
  public void userRepository_findAll()
  {
    final List<User> users = userRepository.findAll();
    assertNotNull(users);
    assertTrue(!users.isEmpty());
  }

  @Test
  public void userRepository_findOne()
  {
    final User user = userRepository.findOne("1");
    assertNotNull(user);
  }

  @Test
  public void userRepository_save()
  {
    final User savedUser = userRepository.save(new User("4","Bob","bob@gmail.com",false));
    final User newUser = userRepository.findOne(savedUser.getId());
    assertNotNull(newUser);
  }

  @Test
  public void mongoUserService_getUsers()
  {
    final List<User> users = mongoUserService.getUsers();
    assertNotNull(users);
    assertTrue(!users.isEmpty());
  }

  @Test
  public void mongoUserService_getUser()
  {
    final User user = mongoUserService.getUser("1");
    assertNotNull(user);
  }

  @Test
  public void mongoUserService_createUser()
  {
    mongoUserService.createUser(new User("4","Bob","bob@gmail.com",false));
    final User newUser = mongoUserService.getUser("4");
    assertNotNull(newUser);
  }
}

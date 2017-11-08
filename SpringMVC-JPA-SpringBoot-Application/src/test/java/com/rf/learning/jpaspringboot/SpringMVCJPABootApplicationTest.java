package com.rf.learning.jpaspringboot;

import com.rf.learning.jpaspringboot.domain.User;
import com.rf.learning.jpaspringboot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest("SpringMVCJPABootApplication")
public class SpringMVCJPABootApplicationTest
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
  public void findAllUsers_nameASC()
  {
    Sort sort = new Sort(Sort.Direction.ASC, "name");
    List<User> users = userRepository.findAll(sort);
    assertNotNull(users);
    assertTrue(!users.isEmpty());
    assertEquals("John", users.get(0).getName());
  }

  @Test
  public void findAllUsers_dualOrder()
  {
    Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "name");
    Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
    Sort sort = new Sort(order1, order2);

    List<User> users = userRepository.findAll(sort);
    assertNotNull(users);
    assertTrue(!users.isEmpty());
    assertEquals("Rod", users.get(0).getName());
  }

  @Test
  public void findAllUsers_pageRequest()
  {
    int size = 1;
    int page = 0;

    Pageable pageable = new PageRequest(page, size);
    Page<User> users = userRepository.findAll(pageable);
    assertNotNull(users);
    assertTrue(users.hasContent());
    assertEquals(3, users.getTotalPages());
    assertEquals("John", users.getContent().get(0).getName());
  }

  @Test
  public void findUserById()
  {
    User user = userRepository.findOne(1);
    assertNotNull(user);
  }

  @Test
  public void findByName()
  {
    User user = userRepository.findByName("John");
    assertNotNull(user);
    assertEquals("John", user.getName());
  }

  @Test
  public void findByNameLike()
  {
    List<User> user = userRepository.findByNameLike("Ro%");
    assertFalse(user.isEmpty());
    final User user1 = user.get(0);
    assertEquals("Rod", user1.getName());
  }

  @Test
  public void createUser()
  {
    User user = new User(null, NAME, EMAIL);
    final User savedUser = userRepository.save(user);
    User newUser = userRepository.findOne(savedUser.getId());
    assertNotNull(newUser);
    assertEquals(NAME, newUser.getName());
    assertEquals(EMAIL, newUser.getEmail());
  }
}

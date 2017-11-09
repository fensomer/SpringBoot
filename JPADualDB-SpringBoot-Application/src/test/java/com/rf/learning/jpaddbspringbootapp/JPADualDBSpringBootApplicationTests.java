package com.rf.learning.jpaddbspringbootapp;

import com.rf.learning.jpaddbspringbootapp.orders.entity.Order;
import com.rf.learning.jpaddbspringbootapp.orders.repository.OrderRepository;
import com.rf.learning.jpaddbspringbootapp.security.entity.User;
import com.rf.learning.jpaddbspringbootapp.security.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest("JPADualDBSpringBootApplication")
public class JPADualDBSpringBootApplicationTests
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void findAllUsers()
	{
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findAllOrders()
	{
		List<Order> orders = orderRepository.findAll();
		assertNotNull(orders);
		assertTrue(!orders.isEmpty());
	}
}

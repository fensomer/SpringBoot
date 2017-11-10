package com.rf.learning.jpaddbspringbootapp.web.controller;

import com.rf.learning.jpaddbspringbootapp.orders.repository.OrderRepository;
import com.rf.learning.jpaddbspringbootapp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @RequestMapping("/")
  public String home(Model model)
  {
    model.addAttribute("users", userRepository.findAll());
    model.addAttribute("orders", orderRepository.findAll());
    return "index";
  }
}

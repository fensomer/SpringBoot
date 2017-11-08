package com.rf.learning.springjdbctemplate.web.controller;

import com.rf.learning.springjdbctemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/")
  public String home(Model model)
  {
    model.addAttribute("users", userRepository.findAll());
    return "index";
  }
}

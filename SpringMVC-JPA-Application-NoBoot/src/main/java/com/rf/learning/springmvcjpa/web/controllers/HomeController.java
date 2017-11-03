package com.rf.learning.springmvcjpa.web.controllers;

import com.rf.learning.springmvcjpa.repositories.UserRepository;
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
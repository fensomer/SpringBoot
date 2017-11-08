package com.rf.com.rf.learning.profilesspringbootapp;

import com.rf.com.rf.learning.profilesspringbootapp.api.SystemPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ProfileSpringBootApplication
{
  @Autowired
  private SystemPrinter systemPrinter;

  @PostConstruct
  public void printImpl()
  {
    systemPrinter.print();
  }

  public static void main(String[] args)
  {
    SpringApplication.run(ProfileSpringBootApplication.class, args);
  }
}

package com.rf.learning;

import com.rf.learning.domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class ConditionalSpringBootApplication
{
  @Autowired
  private List<UserDAO> userDAOList;

  @PostConstruct
  public void listUserDAOs()
  {
    for (UserDAO userDAO : userDAOList)
    {
      System.out.println("***** AVAILABLE USERDAO: " + userDAO.getClass().getCanonicalName() + " *****");
    }
  }

  public static void main(String[] args)
  {
    System.setProperty("dbType", "MYSQL");
    SpringApplication.run(ConditionalSpringBootApplication.class, args);
  }
}

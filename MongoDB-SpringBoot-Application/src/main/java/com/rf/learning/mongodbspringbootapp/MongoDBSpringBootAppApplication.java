package com.rf.learning.mongodbspringbootapp;

import com.rf.learning.mongodbspringbootapp.domain.User;
import com.rf.learning.mongodbspringbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDBSpringBootAppApplication implements CommandLineRunner
{
  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args)
  {
    SpringApplication.run(MongoDBSpringBootAppApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception
  {
    userRepository.save(new User("1", "Robert", "robert@gmail.com", false));
    userRepository.save(new User("2", "Steven", "steven@gmail.com", false));
    userRepository.save(new User("3", "Thomas", "thomas@gmail.com", false));
  }
}

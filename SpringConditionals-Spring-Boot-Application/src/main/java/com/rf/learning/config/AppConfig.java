package com.rf.learning.config;

import com.rf.learning.annontations.DatabaseType;
import com.rf.learning.conditions.MongoDriverPresentCondition;
import com.rf.learning.domain.JdbcUserDAO;
import com.rf.learning.domain.MongoUserDAO;
import com.rf.learning.domain.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
  @Bean
  @DatabaseType("MYSQL")
  public UserDAO jdbcUserDAO()
  {
    return new JdbcUserDAO();
  }

  @Bean
  @DatabaseType("MONGO")
  public UserDAO mongoUserDAO()
  {
    return new MongoUserDAO();
  }

  @Bean
  @Conditional(MongoDriverPresentCondition.class)
  public UserDAO mongoUserDAOCondition()
  {
    return new MongoUserDAO();
  }
}

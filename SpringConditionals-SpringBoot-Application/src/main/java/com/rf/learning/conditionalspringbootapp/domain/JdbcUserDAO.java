package com.rf.learning.conditionalspringbootapp.domain;

import java.util.Arrays;
import java.util.List;

public class JdbcUserDAO implements UserDAO
{
  @Override
  public List<String> getAllUserNames()
  {
    System.out.println("**** Getting usernames from RDMS ****");
    return Arrays.asList("Jim", "John", "Rob");
  }
}

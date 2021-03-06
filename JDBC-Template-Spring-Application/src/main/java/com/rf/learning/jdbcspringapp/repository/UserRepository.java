package com.rf.learning.jdbcspringapp.repository;

import com.rf.learning.jdbcspringapp.domain.User;
import com.rf.learning.jdbcspringapp.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository
{
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Transactional(readOnly = true)
  public List<User> findAll()
  {
    return jdbcTemplate.query("select * from users", new UserRowMapper());
  }
}

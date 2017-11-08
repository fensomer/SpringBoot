package com.rf.learning.jdbcspringapp.mapper;

import com.rf.learning.jdbcspringapp.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>
{
  public User mapRow(ResultSet resultSet, int i) throws SQLException
  {
    User user = new User();
    user.setId(resultSet.getInt("id"));
    user.setName(resultSet.getString("name"));
    user.setEmail(resultSet.getString("email"));
    return user;
  }
}

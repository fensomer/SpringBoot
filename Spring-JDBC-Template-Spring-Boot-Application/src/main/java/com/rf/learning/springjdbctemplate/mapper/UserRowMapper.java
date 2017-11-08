package com.rf.learning.springjdbctemplate.mapper;

import com.rf.learning.springjdbctemplate.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>
{
  public User mapRow(ResultSet resultSet, int i) throws SQLException
  {
    return new User(
        resultSet.getInt("id"),
        resultSet.getString("name"),
        resultSet.getString("email")
    );
  }
}
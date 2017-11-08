package com.rf.learning.jdbcspringbootapp.repository;

import com.rf.learning.jdbcspringbootapp.domain.User;
import com.rf.learning.jdbcspringbootapp.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
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

  @Transactional(readOnly = true)
  public User findUserById(int id)
  {
    return jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id}, new UserRowMapper());
  }

  public User create(final User user)
  {
    final String sql = "insert into users(name, email) values(?,?)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update((connection) ->
    {
      PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getEmail());
      return preparedStatement;
    }, keyHolder);

    int newUserId = keyHolder.getKey().intValue();
    user.setId(newUserId);
    return user;
  }
}

package com.rf.learning.mybatisspringbootapp.mapper;

import com.rf.learning.mybatisspringbootapp.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UserMapper
{
  @Select("select id, name, email from users")
  List<User> findAllUsers();

  @Select("select id, name, email from users where id=#{id}")
  User findUserById(Integer id);

  @Insert("insert into users(name,email) values(#{name},#{email})")
  @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Integer.class)
  void insertUser(User user);
}

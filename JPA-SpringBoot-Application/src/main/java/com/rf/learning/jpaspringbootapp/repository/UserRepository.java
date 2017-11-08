package com.rf.learning.jpaspringbootapp.repository;

import com.rf.learning.jpaspringbootapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>
{
  User findByName(String name);

  List<User> findByNameLike(String name);
}
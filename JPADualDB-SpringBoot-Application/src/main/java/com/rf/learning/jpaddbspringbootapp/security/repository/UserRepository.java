package com.rf.learning.jpaddbspringbootapp.security.repository;

import com.rf.learning.jpaddbspringbootapp.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}
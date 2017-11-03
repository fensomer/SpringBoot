package com.rf.learning.springmvcjpa.repositories;

import com.rf.learning.springmvcjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}

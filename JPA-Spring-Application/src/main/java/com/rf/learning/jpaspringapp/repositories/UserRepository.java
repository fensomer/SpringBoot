package com.rf.learning.jpaspringapp.repositories;

import com.rf.learning.jpaspringapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}

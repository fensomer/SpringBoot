package com.rf.learning.quickspringboot.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}
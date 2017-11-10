package com.rf.learning.mongodbspringbootapp.repository;

import com.rf.learning.mongodbspringbootapp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>
{
}

package com.rishabh.journal.repository;

import com.rishabh.journal.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {


    User findByusername(String username);
}

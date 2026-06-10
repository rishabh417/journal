package com.rishabh.journal.repository;

import com.rishabh.journal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public class UserRepositoryImpl {


    @Autowired
    private MongoTemplate mongoTemplate;


    public List<User> getUserForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("harivansh"));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

}

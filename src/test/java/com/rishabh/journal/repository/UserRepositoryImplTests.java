package com.rishabh.journal.repository;


import com.rishabh.journal.entity.User;
import com.rishabh.journal.service.UserArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class UserRepositoryImplTests {


    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private Environment env;

    @Test
    void checkMongoUri() {
        System.out.println(env.getProperty("spring.data.mongodb.uri"));
    }

    @Test
    public void testNewUser(){
        userRepository.getUserForSA();
    }

}

package com.rishabh.journal.service;

import com.rishabh.journal.entity.User;
import com.rishabh.journal.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.mockito.Mockito.*;


public class UserDetailServiceImplementationTest {

    @InjectMocks
    private UserDetailServiceImplementation userDetailServiceImplementation;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsername(){
        when(userRepository.findByusername(ArgumentMatchers.anyString())).thenReturn(User.builder()
                .username("rishabh")
                .password("password")
                .roles(Collections.singletonList("USER"))
                .build());
        UserDetails user = userDetailServiceImplementation.loadUserByUsername("rishabh");
        Assertions.assertNotNull(user);
    }
}

package com.rishabh.journal.service;

import com.rishabh.journal.entity.User;
import com.rishabh.journal.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @ParameterizedTest
    @ValueSource(strings = {
            "rishabh",
            "shyam",
            "radha",
            "shyamaju"
    })
    public void testFindByUserName(String name){
//        assertEquals(4, 2+2);
        User user = userRepository.findByusername(name);
        assertNotNull(user,"failed for : "+name);

    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1, 21, 3",
            "2, 3, 5",
            "3, 4, 7"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }
}

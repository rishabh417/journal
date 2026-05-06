package com.rishabh.journal.service;

import com.rishabh.journal.entity.JournalEntry;
import com.rishabh.journal.entity.User;
import com.rishabh.journal.repository.JournalEntryRepository;
import com.rishabh.journal.repository.UserRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//no need to write this as we have @Sl4j

    public void saveEntry(User user){
        userRepository.save(user);
    }


    public boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            log.info("hahaha logger ");
            return true;
        } catch (Exception e) {
            log.info("hahaha logger ");
            log.warn("hahaha logger ");
            log.debug("hahaha logger ");
            log.trace("hahaha logger ");
            log.error("hahaha logger ");
            return false;
        }
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId objectId){
        return userRepository.findById(objectId);
    }

    public void deleteById(ObjectId objectId){
        userRepository.deleteById(objectId);
    }

    public User findByusername(@NonNull String username) {
        return userRepository.findByusername(username);
    }

    public void saveNewAdminUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }
}

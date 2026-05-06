package com.rishabh.journal.service;

import com.rishabh.journal.entity.JournalEntry;
import com.rishabh.journal.entity.User;
import com.rishabh.journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username){
        try {
            User user = userService.findByusername(username);
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
            logger.info("save entry of JournalEntryService");
        } catch (Exception e) {
            throw new RuntimeException("An error has occured on save entry in JournalentryService : ",e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId objectId){
        return journalEntryRepository.findById(objectId);
    }

    @Transactional
    public void deleteById(ObjectId objectId, String username){
        try {
            User user = userService.findByusername(username);
            Boolean removed = user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(objectId));

            if(removed){
                userService.saveNewUser(user);
                journalEntryRepository.deleteById(objectId);
            }
        } catch (Exception e) {
            System.out.println("An error has occured on delete entry in JournalentryService : " + e.getMessage());
            throw new RuntimeException(e);
        }


    }

}

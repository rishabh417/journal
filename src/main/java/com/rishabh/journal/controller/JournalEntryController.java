package com.rishabh.journal.controller;

import com.rishabh.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {


//    private Map<String, JournalEntry> journalEntries = new HashMap<>();

//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{myid}")
//    public JournalEntry getJournalEntryById(@PathVariable String myid){
//
//        return journalEntries.get(myid);
//
//    }
//
//    @DeleteMapping("/id/{myid}")
//    public JournalEntry deleteJournalEntryById(@PathVariable String myid){
//
//        return journalEntries.remove(myid);
//    }
//
//    @PutMapping("/id/{myid}")
//    public JournalEntry updateJournalEntryById(@PathVariable String myid, @RequestBody JournalEntry myEntry){
//
//        journalEntries.put(myid,myEntry);
//
//        return journalEntries.get(myid);
//    }


}

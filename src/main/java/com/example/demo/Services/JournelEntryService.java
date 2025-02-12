package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepositry;

@Component
public class JournelEntryService {

@Autowired
private JournalEntryRepositry journalEntryRepositry;


    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepositry.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepositry.findAll();
    }

    public Optional<JournalEntry> findbyId(ObjectId id) {
        return journalEntryRepositry.findById(id);
    }

    public void deleteById(ObjectId myId) { 

        journalEntryRepositry.deleteById(myId);
    }

    
}

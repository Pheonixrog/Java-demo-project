package com.example.demo.Controller;


import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.JournalEntry;
import com.example.demo.Services.JournelEntryService;

@RestController
@RequestMapping("/journal")
public class journelEntryControllerV2 {


    @Autowired
    private JournelEntryService journalEntryService;

   



    @GetMapping
    public List<JournalEntry> getAll() {
            return journalEntryService.getAll();
       
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry ;

    }

    @GetMapping("/id/{myId}")
    public JournalEntry getById(@PathVariable ObjectId myId) {
        return journalEntryService.findbyId(myId).orElse(null);
       
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        JournalEntry oldEntry = journalEntryService.findbyId(myId).orElse(null);
        if(oldEntry != null) {
           oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
              oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
        }
        
        journalEntryService.saveEntry(oldEntry);
        return oldEntry ;
      
    }
    
}

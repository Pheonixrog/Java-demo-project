package com.example.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.JournalEntry;

@Repository
public interface JournalEntryRepositry extends MongoRepository<JournalEntry, ObjectId> {
    
}

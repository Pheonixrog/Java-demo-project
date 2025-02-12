package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JournalEntry {
    @Id
    private ObjectId id;

    private String title;
    private String content;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(LocalDateTime LocalDateTime) {
        this.date = new Date();
    }
   


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {

        this.id = id;
    }  

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }
}

package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String user() {
        return "users: John, Jog";
    }

   @GetMapping("/users/{id}")
    public String userbyId(@PathVariable int id) {
        return "Hello " + id + "!";
    }
    
}

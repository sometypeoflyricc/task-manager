package com.project.demo.controller;

import com.project.demo.entity.User;
import com.project.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//REST controller class for handling HTTP requests
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired //injection of UserService dependency
    private UserService userService;

    //handling of GET requests to get user by name
    //function returns HTTP 200 with user if found, HTTP 404 if not
    @GetMapping("/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        Optional<User> optionalUser = userService.findUserByName(name);
        return optionalUser.map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //handling of GET requests to get list of suggestions in accordance to query
    //function returns HTTP 200 with list of suitable users
    @GetMapping("/suggestions")
    public ResponseEntity<List<User>> getUserSuggestions(@RequestParam String query) {
        List<User> users = userService.findUsersByNameStartingWith(query);
        return ResponseEntity.ok(users);
    }

    //handling of POST requests to create user
    //function returns HTTP 201 with created user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}

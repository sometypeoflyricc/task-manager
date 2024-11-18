package com.project.demo.service;

import com.project.demo.entity.User;
import com.project.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//UserService communicates with UserRepository to execute CRUD operations
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; //injection of UserRepository dependency

    //function for searching of user by name
    //function returns user if search was successful, else empty
    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    //function for creating user in database
    //function returns saved user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //function for searching of all users with names that begin with the specified prefix
    //function returns list of users with names that begin with the specified prefix
    public List<User> findUsersByNameStartingWith(String query) {
        return userRepository.findByNameStartingWith(query);
    }

}

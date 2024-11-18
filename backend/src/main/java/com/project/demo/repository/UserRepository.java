package com.project.demo.repository;

import com.project.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//repository interface for gaining access to and carrying out CRUD operations with User entity in database
//offers built-in functions for performing CRUD operations
public interface UserRepository extends JpaRepository<User, Long> {
    //custom function for searching of user by name
    //function returns user if search was successful, else empty
    Optional<User> findByName(String name);

    //custom function for searching of all users with names that begin with the specified prefix
    //function returns list of users with names that begin with the specified prefix
    List<User> findByNameStartingWith(String name);

}

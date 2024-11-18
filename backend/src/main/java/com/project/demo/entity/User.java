package com.project.demo.entity;

import jakarta.persistence.*;

//User entity is mapped to table "users" in database
@Entity
@Table(name = "users")
public class User {
    //unique identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment primary key
    private Long id;

    //name of communication partner
    @Column(name = "name", nullable = false) //mapped to "name" column, can not be null
    private String name;

    //email of communication partner
    @Column(name = "email", nullable = false, unique = true) //mapped to "email" column, can not be null, must be unique
    private String email;

    //getters and setters for each attribute

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


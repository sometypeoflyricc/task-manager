package com.project.demo.entity;

import jakarta.persistence.*;

//Task entity is mapped to table "tasks" in database
@Entity
@Table(name = "tasks")
public class Task {
    //unique identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment primary key
    private Long id;

    //title of task
    @Column(name = "title", nullable = false) //mapped to "title" column, can not be null
    private String title;

    //deadline of task
    @Column(name = "deadline") //mapped to "deadline" column
    private String deadline;

    //importance level of task
    @Column(name = "importance") //mapped to "importance" column
    private String importance;

    //additional note of task
    @Column(name = "note") //mapped to "note" column
    private String note;

    //demonstrates completion of task
    @Column(name = "completed") //mapped to "completed" column
    private boolean completed;

    //getters and setters for each attribute

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

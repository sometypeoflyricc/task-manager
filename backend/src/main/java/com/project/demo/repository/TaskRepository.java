package com.project.demo.repository;

import com.project.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//repository interface for gaining access to and carrying out CRUD operations with Task entity in database
//offers built-in functions for performing CRUD operations
public interface TaskRepository extends JpaRepository<Task, Long> {
}

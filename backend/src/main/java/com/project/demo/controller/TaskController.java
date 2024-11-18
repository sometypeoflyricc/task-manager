package com.project.demo.controller;

import com.project.demo.entity.Task;
import com.project.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST controller class for handling HTTP requests
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired //injection of TaskService dependency
    private TaskService taskService;

    //handling of GET requests to get all tasks
    //function returns list of all tasks
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    //handling of POST requests to create task
    //function returns created task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    //handling of PUT requests to update task
    //function returns updated task object
    //id of task that needs to be updated
    //taskDetails - new details
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    //handling of DELETE requests to delete task by its id
    //function returns HTTP 204 if operation was successful, 404 if task was not present
    //id of task that needs to be deleted
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        System.out.println("Deleting task with ID: " + id);
        if (taskService.deleteTask(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            System.out.println("Task with ID: " + id + " not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

package com.project.demo.service;

import com.project.demo.entity.Task;
import com.project.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//TaskService communicates with TaskRepository to execute CRUD operations
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository; //injection of TaskRepository dependency

    //function for getting all tasks from database
    //function returns list of all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //function for creating task in database
    //function returns saved task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    //function for updating task in database
    //id of task that needs to be updated
    //taskDetails - new details
    //function returns updated task if present, else null
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDetails.getTitle());
            task.setDeadline(taskDetails.getDeadline());
            task.setImportance(taskDetails.getImportance());
            task.setNote(taskDetails.getNote());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }
        return null;
    }

    //function for deleting task from database
    //id of task that needs to be deleted
    //function returns true in the case of successful deletion, false in the case when task was not found
    public boolean deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
            return true;
        }
        return false;
    }


}

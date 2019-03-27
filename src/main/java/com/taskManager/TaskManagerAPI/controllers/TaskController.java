package com.taskManager.TaskManagerAPI.controllers;

import com.taskManager.TaskManagerAPI.exceptions.TaskException;
import com.taskManager.TaskManagerAPI.model.Task;
import com.taskManager.TaskManagerAPI.model.User;
import com.taskManager.TaskManagerAPI.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/Task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/allTask")
    public ResponseEntity<?> getTaskList(){
        return new ResponseEntity<>(taskService.geTasksList(), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable(name = "taskId") String taskId){
        try {
            return new ResponseEntity<>(taskService.getTaskById(taskId),HttpStatus.OK);
        } catch (TaskException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error task no encontrado",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskById(@PathVariable(name = "taskId") String taskId){
        try {
            taskService.removeTask(taskId);
            return new ResponseEntity<>("Task eliminado",HttpStatus.OK);
        } catch (TaskException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error usuario no encontrado",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping ("/{userId}")
    public ResponseEntity<?> getTaskByUserId(@PathVariable(name = "userId") String userId){
        try {
            taskService.getTasksByUserId(userId);
            return new ResponseEntity<>(taskService.getTasksByUserId(userId),HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error usuario no encontrado",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(taskService.updateTask(task.getId(),task.getDescription(),task.getResponsible(),task.getStatus(),task.getDueDate()), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> assignedTaskToUser(@PathVariable(name = "taskId") String taskId,@RequestBody User user){
        try {
            return new ResponseEntity<>(taskService.assignedTaskToUser(taskId,user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

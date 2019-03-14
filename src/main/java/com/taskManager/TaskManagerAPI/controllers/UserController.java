package com.taskManager.TaskManagerAPI.controllers;

import com.taskManager.TaskManagerAPI.exceptions.UserException;
import com.taskManager.TaskManagerAPI.model.User;
import com.taskManager.TaskManagerAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<?> getUsersList(){
        return new ResponseEntity<>(userService.getUsersList(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId){
        try {
            return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
        } catch (UserException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error usuario no encontrado",HttpStatus.NOT_FOUND);
        }

    }

    
}

package com.taskManager.TaskManagerAPI.services;

import com.taskManager.TaskManagerAPI.exceptions.UserException;
import com.taskManager.TaskManagerAPI.model.User;
import java.util.List;

public interface UserService {
    public List<User> getUsersList();

    public User getUserById(String userId) throws UserException;

    public User createUser(String userId, String name, String email, String password) throws UserException;

    public User updateUser(String userId, String name, String email, String password) throws UserException;

    public void removeUser(String userId) throws UserException;
}

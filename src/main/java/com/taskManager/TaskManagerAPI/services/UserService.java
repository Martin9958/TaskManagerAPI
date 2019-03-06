package com.taskManager.TaskManagerAPI.services;

import com.taskManager.TaskManagerAPI.model.User;
import java.util.List;

public interface UserService {
    public List<User> getUsersList();

    public User getUserById(int userId);

    public User createUser(int userId, String name, String email, String password);

    public User updateUser();

    public void removeUser();
}

package com.taskManager.TaskManagerAPI.services.Impl;

import com.taskManager.TaskManagerAPI.model.User;
import com.taskManager.TaskManagerAPI.services.UserService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    HashMap<String,User> usersMap = new HashMap<>();

    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User createUser(String userId, String name, String email, String password) {
        return null;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void removeUser() {

    }

}

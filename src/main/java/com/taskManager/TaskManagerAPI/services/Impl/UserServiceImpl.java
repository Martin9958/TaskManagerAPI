package com.taskManager.TaskManagerAPI.services.Impl;

import com.taskManager.TaskManagerAPI.exceptions.UserException;
import com.taskManager.TaskManagerAPI.model.User;
import com.taskManager.TaskManagerAPI.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    HashMap<String,User> usersMap = new HashMap<>();


    @Override
    public List<User> getUsersList() {
        List<User> users; users = new ArrayList<User>(usersMap.values());
        return users;
    }

    @Override
    public User getUserById(String userId) throws UserException {
        if(!usersMap.containsKey(userId)){
            throw new UserException("No se encontro el usuario");
        }
        User user = usersMap.get(userId);
        return user;
    }

    @Override
    public User createUser(String userId, String name, String email, String password) throws UserException {
        if(usersMap.containsKey(userId)){
            throw new UserException("No se puede crear el usuario, si quiere actualicelo");
        }
        User user = new User(userId,name,email,password);
        usersMap.put(userId,user);
        return user;

    }

    @Override
    public User updateUser(String userId, String name, String email, String password)throws UserException{
        if(!usersMap.containsKey(userId)){
            throw new UserException("No se encontro el usuario");
        }
        User user = getUserById(userId);
        user.setId(userId);
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    @Override
    public void removeUser(String userId) throws UserException {
        if(!usersMap.containsKey(userId)){
            throw new UserException("No se encontro el usuario");
        }
        usersMap.remove(userId);
    }

}

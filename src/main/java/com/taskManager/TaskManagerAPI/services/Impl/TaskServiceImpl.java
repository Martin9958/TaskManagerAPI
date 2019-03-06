package com.taskManager.TaskManagerAPI.services.Impl;

import com.taskManager.TaskManagerAPI.model.Task;
import com.taskManager.TaskManagerAPI.model.User;
import com.taskManager.TaskManagerAPI.services.TaskService;

import java.util.Date;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> geTasksList() {
        return null;
    }

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return null;
    }

    @Override
    public Task assignedTaskToUser(String taskId, User user) {
        return null;
    }

    @Override
    public void removeTask(String taskId) {

    }

    @Override
    public Task updateTask(String id, String description, User responsible, String status, Date dueDate) {
        return null;
    }


}

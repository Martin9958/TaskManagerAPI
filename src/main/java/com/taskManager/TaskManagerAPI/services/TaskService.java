package com.taskManager.TaskManagerAPI.services;

import com.taskManager.TaskManagerAPI.model.Task;
import com.taskManager.TaskManagerAPI.model.User;

import java.util.Date;
import java.util.List;

public interface TaskService {
    public List<Task> geTasksList();

    public Task getTaskById(String id);

    public List<Task> getTasksByUserId(String userId);

    public Task assignedTaskToUser(String taskId, User user);

    public void removeTask(String taskId);

    public Task updateTask(String id,String description, User responsible, String status, Date dueDate);
}

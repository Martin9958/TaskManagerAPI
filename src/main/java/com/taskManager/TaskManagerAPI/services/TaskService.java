package com.taskManager.TaskManagerAPI.services;

import com.taskManager.TaskManagerAPI.exceptions.TaskException;
import com.taskManager.TaskManagerAPI.model.Task;
import com.taskManager.TaskManagerAPI.model.User;

import java.util.Date;
import java.util.List;

public interface TaskService {
    public List<Task> geTasksList();

    public Task getTaskById(String id) throws TaskException;

    public List<Task> getTasksByUserId(String userId);

    public Task assignedTaskToUser(String taskId, User user) throws TaskException;

    public void removeTask(String taskId) throws TaskException;

    public Task updateTask(String id,String description, User responsible, String status, Date dueDate) throws TaskException;
}

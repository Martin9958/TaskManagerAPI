package com.taskManager.TaskManagerAPI.services;

import com.taskManager.TaskManagerAPI.model.Task;
import com.taskManager.TaskManagerAPI.model.User;
import java.util.List;

public interface TaskService {
    public List<Task> geTasksList();

    public Task getTaskById(String id);

    public List<Task> getTasksByUserId(String userId);

    public Task assignedTaskToUser(String taskId, User user);

    public void removeTask();

    public Task updateTask(Task task);
}

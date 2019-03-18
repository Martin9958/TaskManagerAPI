package com.taskManager.TaskManagerAPI.services.Impl;

import com.taskManager.TaskManagerAPI.exceptions.TaskException;
import com.taskManager.TaskManagerAPI.model.Task;
import com.taskManager.TaskManagerAPI.model.User;
import com.taskManager.TaskManagerAPI.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskServiceImpl implements TaskService {

    HashMap <String, Task> taskMap = new HashMap<>();

    @Override
    public List<Task> geTasksList() {
        List<Task> tasks = new ArrayList<Task>(taskMap.values());
        return tasks;
    }

    @Override
    public Task getTaskById(String id) throws TaskException {
        if(!taskMap.containsKey(id)){
            throw new TaskException("No se encontro ninguna tarea con ese id");
        }
        Task task = taskMap.get(id);
        return task;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        List<Task> tasks = geTasksList();
        List<Task> userTasks = new ArrayList<Task>();
        for (int i=0; i<tasks.size();i++){
            if(tasks.get(i).getResponsible().getId().equals(userId)){
                userTasks.add(tasks.get(i));
            }
        }
        return userTasks;
    }

    @Override
    public Task assignedTaskToUser(String taskId, User user) throws TaskException{
        if(!taskMap.containsKey(taskId)){
            throw new TaskException("No se encuentra esta tarea en la lista de tareas creadas");
        }
        Task taskNewAssigned = null;
        List<Task> task = geTasksList();
        for (int i=0; i< task.size();i++){
            if(task.get(i).getId().equals(taskId)){
                task.get(i).setResponsible(user);
                taskNewAssigned = task.get(i);
            }
        }
        return taskNewAssigned;
    }

    @Override
    public void removeTask(String taskId) throws TaskException {
        if(!taskMap.containsKey(taskId)){
            throw new TaskException("No se encuentra esta tarea en la lista de tareas creadas");
        }
        taskMap.remove(taskId);
    }

    @Override
    public Task updateTask(String id, String description, User responsible, String status, Date dueDate) throws TaskException {
        if(!taskMap.containsKey(id)){
            throw new TaskException("No se encontro el usuario");
        }
        Task task = getTaskById(id);
        task.setId(id);
        task.setDescription(description);
        task.setResponsible(responsible);
        task.setStatus(status);
        task.setDueDate(dueDate);
        return task;
    }


}

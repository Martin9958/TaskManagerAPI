package com.taskManager.TaskManagerAPI.model;

import java.util.Date;
import java.util.Objects;

public class Task {

    private String id;
    private String description;
    private User responsible;
    private String status;
    private Date dueDate;

    public Task() {
    }

    public Task(String id,String description, User responsible, String status, Date dueDate) {
        this.id = id;
        this.description = description;
        this.responsible = responsible;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", responsible=" + responsible +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(responsible, task.responsible) &&
                Objects.equals(status, task.status) &&
                Objects.equals(dueDate, task.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, responsible, status, dueDate);
    }
}

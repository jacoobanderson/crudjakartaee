package com.example.crud.services;


import com.example.crud.entities.TasksEntity;
import com.example.crud.entities.UsersEntity;
import com.example.crud.repositories.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    @Transactional
    public List<TasksEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public List<TasksEntity> getTasksByUser(UsersEntity user) {
        return taskRepository.findByUser(user);
    }

    @Transactional
    public void createTask(TasksEntity task) {
        taskRepository.create(task);
    }

    @Transactional
    public void updateTask(TasksEntity task) {
        taskRepository.update(task);
    }

    @Transactional
    public void deleteTask(TasksEntity task) {
        taskRepository.delete(task);
    }

    public TasksEntity getTaskById(Long id) {
        return taskRepository.findById(id);
    }
}


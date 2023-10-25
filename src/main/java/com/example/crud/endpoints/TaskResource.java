package com.example.crud.endpoints;

import com.example.crud.entities.TasksEntity;
import com.example.crud.services.TaskService;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tasks")
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    private TaskService taskService;

    @GET
    public List<TasksEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GET
    @Path("/{id}")
    public TasksEntity getTaskById(@PathParam("id") Long id) {
        return taskService.getTaskById(id);
    }

    @POST
    @Path("/")
    public void createTask(TasksEntity task) {
        taskService.createTask(task);
    }

    @PUT
    @Path("/{id}")
    public void updateTask(@PathParam("id") Long id, TasksEntity task) {
        task.setId(id);
        taskService.updateTask(task);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        TasksEntity task = taskService.getTaskById(id);
        if (task != null) {
            taskService.deleteTask(task);
        }
    }
}

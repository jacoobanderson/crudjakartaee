package com.example.crud.repositories;
import com.example.crud.entities.TasksEntity;
import com.example.crud.entities.UsersEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@RequestScoped
public class TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TasksEntity findById(Long id) {
        return entityManager.find(TasksEntity.class, id);
    }

    public List<TasksEntity> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    public List<TasksEntity> findByUser(UsersEntity user) {
        return entityManager.createQuery("SELECT t FROM TasksEntity t WHERE t.userId = :userId", TasksEntity.class)
                .setParameter("userId", user.getId())
                .getResultList();
    }

    public void create(TasksEntity task) {
        entityManager.persist(task);
    }

    public void update(TasksEntity task) {
        entityManager.merge(task);
    }

    public void delete(TasksEntity task) {
        entityManager.remove(entityManager.contains(task) ? task : entityManager.merge(task));
    }
}

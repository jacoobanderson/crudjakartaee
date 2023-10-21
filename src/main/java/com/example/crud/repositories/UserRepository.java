package com.example.crud.repositories;

import com.example.crud.entities.UsersEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UsersEntity findById(Long id) {
        return entityManager.find(UsersEntity.class, id);
    }

    public UsersEntity findByUsername(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM UsersEntity u WHERE u.username = :username", UsersEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // User not found
        }
    }

    public List<UsersEntity> findAll() {
        return entityManager.createQuery("SELECT u FROM UsersEntity u", UsersEntity.class).getResultList();
    }

    public void create(UsersEntity user) {
        entityManager.persist(user);
    }

    public void update(UsersEntity user) {
        entityManager.merge(user);
    }

    public void delete(UsersEntity user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
}
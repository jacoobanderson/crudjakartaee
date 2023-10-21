package com.example.crud.services;

import com.example.crud.entities.UsersEntity;
import com.example.crud.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    @Transactional
    public UsersEntity getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public UsersEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void createUser(UsersEntity user) {
        userRepository.create(user);
    }

    @Transactional
    public void updateUser(UsersEntity user) {
        userRepository.update(user);
    }

    @Transactional
    public void deleteUser(UsersEntity user) {
        userRepository.delete(user);
    }
}

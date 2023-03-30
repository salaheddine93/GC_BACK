package com.example.gcback.services;

import com.example.gcback.entities.User;

import java.util.List;

public interface UserService {

    User addNewUser(User user);
    User getUserById(Long id);
    List<User> listUsers();
    void deleteUser(Long id);
    void addRoletoUser(String userName, String roleName);
}

package com.example.gcback.service;

import com.example.gcback.entities.Role;
import com.example.gcback.entities.User;

import java.util.List;

public interface UserService {

    User addNewUser(User user);
    User getUserById(Long id);
    List<User> listUsers();
    void deleteUser(Long id);
    void addRoletoUser(String roleName, String userName);
}

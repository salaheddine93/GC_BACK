package com.example.gcback.service;

import com.example.gcback.dao.RoleRepo;
import com.example.gcback.dao.UserRepo;
import com.example.gcback.entities.Role;
import com.example.gcback.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    //@Autowired private PasswordEn

    @Override
    public User addNewUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void addRoletoUser(String roleName, String userName) {
        Role role = roleRepo.findByRolename(roleName);
        User user = userRepo.findByUsername(userName);
        user.getRoles().add(role);
    }
}

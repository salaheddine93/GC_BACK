package com.example.gcback.services;

import com.example.gcback.repositories.RoleRepo;
import com.example.gcback.repositories.UserRepo;
import com.example.gcback.entities.Role;
import com.example.gcback.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public void addRoletoUser(String userName, String roleName) {
        Role role = roleRepo.findByRolename(roleName);
        Optional<User> user = userRepo.findByUsername(userName);
        user.get().getRoles().add(role);
    }
}

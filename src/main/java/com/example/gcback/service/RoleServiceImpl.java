package com.example.gcback.service;

import com.example.gcback.dao.RoleRepo;
import com.example.gcback.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role addNewRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepo.findById(id).get();
    }

    @Override
    public List<Role> listRoles() {
        return roleRepo.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }
}

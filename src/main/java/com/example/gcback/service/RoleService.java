package com.example.gcback.service;

import com.example.gcback.entities.Role;

import java.util.List;


public interface RoleService {

    Role addNewRole(Role role);
    Role getRoleById(Long id);
    List<Role> listRoles();
    void deleteRole(Long id);
}

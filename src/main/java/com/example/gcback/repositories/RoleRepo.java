package com.example.gcback.repositories;

import com.example.gcback.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRolename (String rolename);
}

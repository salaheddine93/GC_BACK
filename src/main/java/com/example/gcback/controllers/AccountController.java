package com.example.gcback.controllers;

import com.example.gcback.entities.Role;
import com.example.gcback.entities.User;
import com.example.gcback.services.RoleService;
import com.example.gcback.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping(path = "/users")
    public List<User> allUsers(){
        return userService.listUsers();
    }

    @PostMapping(path = "/addUser")
    public User saveUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping(path = "/roles")
    public List<Role> allRoles(){
        return roleService.listRoles();
    }

    @PostMapping(path = "/addRole")
    public Role saveRole(@RequestBody Role role){
        return roleService.addNewRole(role);
    }

    @DeleteMapping(path = "/roles/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }



    @PostMapping(path = "/addRoleToUser")
    public void roleToUser(@RequestBody RoleUserForm roleUserForm){
        userService.addRoletoUser(roleUserForm.getUserName(), roleUserForm.getRoleName());
    }
}

@Data
class RoleUserForm{
    private String userName;
    private String roleName;
}

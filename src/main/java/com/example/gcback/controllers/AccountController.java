package com.example.gcback.controllers;

import com.example.gcback.dto.request.RoleRequestDto;
import com.example.gcback.dto.request.UserRequestDto;
import com.example.gcback.dto.response.RoleResponseDto;
import com.example.gcback.dto.response.UserResponseDto;
import com.example.gcback.services.interfaces.RoleService;
import com.example.gcback.services.interfaces.UserService;
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
    public List<UserResponseDto> allUsers(){
        return userService.listUsers();
    }

    @PostMapping(path = "/addUser")
    public UserResponseDto saveUser(@RequestBody UserRequestDto userRequestDto){
        return userService.addNewUser(userRequestDto);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping(path = "/roles")
    public List<RoleResponseDto> allRoles(){
        return roleService.listRoles();
    }

    @PostMapping(path = "/addRole")
    public RoleResponseDto saveRole(@RequestBody RoleRequestDto roleRequestDto){
        return roleService.addNewRole(roleRequestDto);
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

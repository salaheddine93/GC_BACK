package com.example.gcback.services.interfaces;

import com.example.gcback.dto.request.UserRequestDto;
import com.example.gcback.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto addNewUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> listUsers();
    void deleteUser(Long id);
    void addRoletoUser(String userName, String roleName);
}

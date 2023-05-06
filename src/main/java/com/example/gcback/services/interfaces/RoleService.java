package com.example.gcback.services.interfaces;

import com.example.gcback.dto.request.RoleRequestDto;
import com.example.gcback.dto.response.RoleResponseDto;

import java.util.List;


public interface RoleService {

    RoleResponseDto addNewRole(RoleRequestDto roleRequestDto);
    RoleResponseDto getRoleById(Long id);
    List<RoleResponseDto> listRoles();
    void deleteRole(Long id);
}

package com.example.gcback.services.implementations;

import com.example.gcback.dto.request.RoleRequestDto;
import com.example.gcback.dto.response.RoleResponseDto;
import com.example.gcback.dto.response.UserResponseDto;
import com.example.gcback.entities.User;
import com.example.gcback.repositories.RoleRepo;
import com.example.gcback.entities.Role;
import com.example.gcback.services.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;
    private final ModelMapper modelMapper;

    @Override
    public RoleResponseDto addNewRole(RoleRequestDto roleRequestDto) {
        Role role = modelMapper.map(roleRequestDto, Role.class);
        Role roleSaved = roleRepo.save(role);
        return modelMapper.map(roleSaved, RoleResponseDto.class);
    }


    @Override
    public RoleResponseDto getRoleById(Long id) {
        Role role = roleRepo.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return modelMapper.map(role, RoleResponseDto.class);
    }

    @Override
    public List<RoleResponseDto> listRoles() {
        return roleRepo.findAll()
                .stream().map(el -> modelMapper.map(el, RoleResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }
}

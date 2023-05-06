package com.example.gcback.services.implementations;

import com.example.gcback.dto.request.UserRequestDto;
import com.example.gcback.dto.response.UserResponseDto;
import com.example.gcback.repositories.RoleRepo;
import com.example.gcback.repositories.UserRepo;
import com.example.gcback.entities.Role;
import com.example.gcback.entities.User;
import com.example.gcback.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto addNewUser(UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userSaved = userRepo.save(user);
        return modelMapper.map(userSaved, UserResponseDto.class);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> listUsers() {
        return userRepo.findAll()
                .stream().map(el -> modelMapper.map(el, UserResponseDto.class))
                .collect(Collectors.toList());
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

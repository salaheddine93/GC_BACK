package com.example.gcback.dto.response;

import com.example.gcback.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {

    private Long id;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
}

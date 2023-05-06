package com.example.gcback.dto.request;

import com.example.gcback.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {

    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
}

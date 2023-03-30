package com.example.gcback.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestAPI {

    @GetMapping("/testServer")
    //@PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String, Object> testServer(Authentication authentication){
        return Map.of(
                "Server Status ","Server is running",
                "Username",authentication.getName(),
                "Roles",authentication.getAuthorities()
        );
    }

    @PostMapping("/saveData")
    //@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String, String> saveData(String data){
        return Map.of("Saved Data ", data);
    }

}

package com.example.gcback.controllers;

import com.example.gcback.dto.LoginRequest;
import com.example.gcback.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {
    private final JwtDecoder jwtDecoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;


    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> jwtToken(@RequestBody LoginRequest loginRequest){

        String subject = null;
        List<String> scope = null;

        if (loginRequest.getGrantType().equals("password")){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            subject = authentication.getName();
            scope = authentication.getAuthorities()
                    .stream().map(auth->auth.getAuthority())
                    .collect(Collectors.toList());

        }else if (loginRequest.getGrantType().equals("refreshToken")){
            if (loginRequest.getRefreshToken()==null){
                return new ResponseEntity<>(Map.of("errorMessage","refreshToken is required"), HttpStatus.UNAUTHORIZED);
            }
            Jwt decodeJWT = null;
            try {
                decodeJWT = jwtDecoder.decode(loginRequest.getRefreshToken());
            } catch (JwtException e) {
                return new ResponseEntity<>(Map.of("errorMessage", e.getMessage()), HttpStatus.UNAUTHORIZED);
            }
            subject = decodeJWT.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            scope = authorities.stream().map(auth->auth.getAuthority()).collect(Collectors.toList());
        }
        return new ResponseEntity<>(tokenService.generateToken(subject,scope,loginRequest.getWithRefreshToken()), HttpStatus.OK);
    }
}

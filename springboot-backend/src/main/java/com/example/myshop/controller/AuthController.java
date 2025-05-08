package com.example.myshop.controller;

import com.example.myshop.dto.LoginRequest;
import com.example.myshop.dto.LoginResponse;
import com.example.myshop.model.User;
import com.example.myshop.UserRepository;
import com.example.myshop.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    private final UserRepository userRepository;
    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @PostMapping(value = "/login", consumes = "application/json")
//    public ResponseEntity<?> loginJson(@RequestBody LoginRequest loginRequest) {
//        try {
//            Authentication auth = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getUsername(),
//                            loginRequest.getPassword()
//                    )
//            );
//            String token = jwtUtil.generateToken(auth.getName());
//            return ResponseEntity.ok(Collections.singletonMap("token", token));
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<?> loginJson(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            String token = jwtUtil.generateToken(auth.getName());
            var user = userRepository.findByUsername(auth.getName())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            LoginResponse response = new LoginResponse(
                    token,
                    user.getUsername(),
                    user.isEnabled()
            );

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}

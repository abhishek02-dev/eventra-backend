package com.eventManagement.Eventra.controller;

import com.eventManagement.Eventra.dto.LoginRequest;
import com.eventManagement.Eventra.dto.LoginResponse;
import com.eventManagement.Eventra.model.User;
import com.eventManagement.Eventra.repository.UserRepository;
import com.eventManagement.Eventra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setRole("user");
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println("Login attempt for: " + request.getEmail());

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            System.out.println("User not found");
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        System.out.println("Found user: " + user.get().getEmail());
        System.out.println("Found user: " + user.get().getUsername());

        if (!user.get().getPassword().equals(request.getPassword())) {
            System.out.println("Password mismatch");
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        LoginResponse response = new LoginResponse(user.get().getEmail(), user.get().getRole(),user.get().getUsername());
        return ResponseEntity.ok(response);
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}


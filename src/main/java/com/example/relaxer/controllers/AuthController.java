package com.example.relaxer.controllers;

import com.example.relaxer.DTO.RegisterRequest;
import com.example.relaxer.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Auth API", description = "Auth аккаунта")
public class AuthController {
    private final AuthService authService;

    @Operation(
            summary = "Register", description = "Register now", responses = {
            @ApiResponse(responseCode = "200", description = "Register successfully")
    }

    )
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
        return ResponseEntity.ok("Register was successfully");
    }

    @Operation(summary = "Login", description = "Login for what?", responses = {
            @ApiResponse(responseCode = "200", description = "Login successfully")
    })
    @GetMapping("/me")
    public ResponseEntity<?> whoAmI(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body("Not authenticated");
        }
        return ResponseEntity.ok("Current user: " + authentication.getName());
    }
}
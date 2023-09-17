package com.example.kyrgyzpatentbackend.api;


import com.example.kyrgyzpatentbackend.db.dto.request.AuthenticateRequest;
import com.example.kyrgyzpatentbackend.db.dto.request.RegisterRequest;
import com.example.kyrgyzpatentbackend.db.dto.response.AuthenticationResponse;
import com.example.kyrgyzpatentbackend.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @Operation(summary = "Authenticate a user", description = "This method validates the request and authenticates a user.")
    @PostMapping("/sign-in")
    public AuthenticationResponse signIn(@RequestBody @Valid AuthenticateRequest request) {
        return authenticationService.authenticate(request);
    }

    @Operation(summary = "Register a new user", description = "This method validates the request and register a new user.")
    @PostMapping("/sign-up")
    public AuthenticationResponse signUp(@RequestBody @Valid RegisterRequest request) {
        return authenticationService.register(request);
    }
}

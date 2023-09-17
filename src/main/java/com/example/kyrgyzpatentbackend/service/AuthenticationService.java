package com.example.kyrgyzpatentbackend.service;

import com.example.kyrgyzpatentbackend.db.dto.request.AuthenticateRequest;
import com.example.kyrgyzpatentbackend.db.dto.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticateRequest request);

}

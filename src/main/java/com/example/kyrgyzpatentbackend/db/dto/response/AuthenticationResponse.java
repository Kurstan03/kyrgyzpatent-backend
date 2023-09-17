package com.example.kyrgyzpatentbackend.db.dto.response;

import com.example.kyrgyzpatentbackend.db.model.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String email,
        Role role,
        String token
) {
}

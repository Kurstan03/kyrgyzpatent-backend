package com.example.kyrgyzpatentbackend.db.dto.response;

import lombok.Builder;

@Builder
public record CategoryResponse(
        Long id,
        String name
) {
}

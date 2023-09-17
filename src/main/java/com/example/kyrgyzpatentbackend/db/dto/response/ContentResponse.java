package com.example.kyrgyzpatentbackend.db.dto.response;

import lombok.Builder;

@Builder
public record ContentResponse(
        Long id,
        String title,
        String contentNumber,
        String pdfLink
) {
}

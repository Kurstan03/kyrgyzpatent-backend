package com.example.kyrgyzpatentbackend.db.dto.request;

import lombok.Builder;

@Builder
public record ContentRequest(
        Long categoryId,
        String title,
        String contentNumber,
        String pdfLink
) {
}

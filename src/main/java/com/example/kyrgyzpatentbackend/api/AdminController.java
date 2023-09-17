package com.example.kyrgyzpatentbackend.api;

import com.example.kyrgyzpatentbackend.db.dto.request.ContentRequest;
import com.example.kyrgyzpatentbackend.db.dto.request.SimpleResponse;
import com.example.kyrgyzpatentbackend.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "Admin content API")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final CategoryService categoryService;

    @Operation(summary = "Add a new content", description = "Add a new content to category")
    @PostMapping("/content")
    public SimpleResponse addContent(@RequestBody ContentRequest request) {
        return categoryService.addContent(request);
    }
}

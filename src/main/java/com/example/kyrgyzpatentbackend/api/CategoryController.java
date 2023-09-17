package com.example.kyrgyzpatentbackend.api;

import com.example.kyrgyzpatentbackend.db.dto.response.ContentResponse;
import com.example.kyrgyzpatentbackend.db.dto.response.CategoryResponse;
import com.example.kyrgyzpatentbackend.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
@Tag(name = "Category API", description = "API for working with categories")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "Get all categories", description = "This method to get all categories")
    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @Operation(summary = "Get contents of category by id", description = "This method to get contents of category by id")
    @GetMapping("/{categoryId}")
    public List<ContentResponse> getContentsOfCategory(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @Operation(summary = "Search contents", description = "Global search contents with his title, category, content number")
    @GetMapping("/search")
    public List<ContentResponse> searchContents(@RequestParam String search) {
        return categoryService.searchContents(search);
    }
}

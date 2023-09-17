package com.example.kyrgyzpatentbackend.service;

import com.example.kyrgyzpatentbackend.db.dto.response.CategoryResponse;
import com.example.kyrgyzpatentbackend.db.dto.response.ContentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryResponse> getAll();

    List<ContentResponse> getById(Long categoryId);
}

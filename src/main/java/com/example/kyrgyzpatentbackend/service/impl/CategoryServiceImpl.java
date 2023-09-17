package com.example.kyrgyzpatentbackend.service.impl;

import com.example.kyrgyzpatentbackend.db.dto.response.CategoryResponse;
import com.example.kyrgyzpatentbackend.db.dto.response.ContentResponse;
import com.example.kyrgyzpatentbackend.repository.CategoryRepository;
import com.example.kyrgyzpatentbackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public List<ContentResponse> getById(Long categoryId) {
        return categoryRepository.getContents(categoryId);
    }
}

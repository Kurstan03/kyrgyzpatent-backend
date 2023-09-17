package com.example.kyrgyzpatentbackend.service.impl;

import com.example.kyrgyzpatentbackend.db.dto.request.ContentRequest;
import com.example.kyrgyzpatentbackend.db.dto.request.SimpleResponse;
import com.example.kyrgyzpatentbackend.db.dto.response.CategoryResponse;
import com.example.kyrgyzpatentbackend.db.dto.response.ContentResponse;
import com.example.kyrgyzpatentbackend.db.exceptions.NotFoundException;
import com.example.kyrgyzpatentbackend.db.model.Category;
import com.example.kyrgyzpatentbackend.db.model.Content;
import com.example.kyrgyzpatentbackend.repository.CategoryRepository;
import com.example.kyrgyzpatentbackend.repository.ContentRepository;
import com.example.kyrgyzpatentbackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ContentRepository contentRepository;

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public List<ContentResponse> getById(Long categoryId) {
        return categoryRepository.getContents(categoryId);
    }

    @Override
    public List<ContentResponse> searchContents(String search) {
        return categoryRepository.searchContents(search);
    }

    @Override
    public SimpleResponse addContent(ContentRequest request) {
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(
                () -> new NotFoundException("Category not found"));
        Content content = new Content();
        content.setTitle(request.title());
        content.setContentNumber(request.contentNumber());
        content.setLinkPdf(request.pdfLink());
        content.setCategory(category);
        contentRepository.save(content);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .build();
    }
}


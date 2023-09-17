package com.example.kyrgyzpatentbackend.repository;

import com.example.kyrgyzpatentbackend.db.dto.response.CategoryResponse;
import com.example.kyrgyzpatentbackend.db.dto.response.ContentResponse;
import com.example.kyrgyzpatentbackend.db.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT NEW com.example.kyrgyzpatentbackend.db.dto.response.CategoryResponse(c.id, c.name) FROM Category c")
    List<CategoryResponse> getAll();

    @Query("""
            SELECT NEW com.example.kyrgyzpatentbackend.db.dto.response.ContentResponse(
            c.id, c.title, c.contentNumber, c.linkPdf
            )
            FROM Content c WHERE c.category.id = :categoryId
            """)
    List<ContentResponse> getContents(Long categoryId);
}
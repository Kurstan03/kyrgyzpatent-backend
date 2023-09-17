package com.example.kyrgyzpatentbackend.repository;

import com.example.kyrgyzpatentbackend.db.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
package com.example.kyrgyzpatentbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public interface S3Service {
    Map<String, String> uploadFile(MultipartFile file) throws IOException;

    Map<String, String> deleteFile(String fileLink);
}

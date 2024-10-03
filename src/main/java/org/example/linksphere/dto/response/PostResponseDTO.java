package org.example.linksphere.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
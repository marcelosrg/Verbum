package com.verbum.backend.dto.post;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResponsePostDto(
        UUID id,
        String title,
        String content,
        LocalDateTime publicationDate,
        Boolean status,
        String urlImage,
        UUID userId) {
}

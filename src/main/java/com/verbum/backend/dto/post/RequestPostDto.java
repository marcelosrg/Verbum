package com.verbum.backend.dto.post;


import java.time.LocalDateTime;
import java.util.UUID;


public record RequestPostDto (
        String title,
        String content,
        LocalDateTime publicationDate,
        Boolean status,
        String urlImage,
        UUID userId
){


}

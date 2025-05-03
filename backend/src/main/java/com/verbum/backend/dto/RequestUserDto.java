package com.verbum.backend.dto;

import com.verbum.backend.model.User;

import java.time.LocalDateTime;

public record RequestUserDto(
        String name,
        String email,
        String password,
        String biography,
        String image) {

}

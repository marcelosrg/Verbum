package com.verbum.backend.dto;

public record UpdateUserDto(
        String name,
        String email,
        String password,
        String biography,
        String image) {
}

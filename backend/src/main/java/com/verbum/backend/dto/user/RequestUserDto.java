package com.verbum.backend.dto.user;

public record RequestUserDto(
        String name,
        String email,
        String password,
        String biography,
        String image) {

}

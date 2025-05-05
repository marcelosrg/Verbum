package com.verbum.backend.dto;

public record ResponseUserDto (
        String name,
        String email,
        String biography,
        String image
){

}

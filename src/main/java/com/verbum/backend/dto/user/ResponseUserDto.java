package com.verbum.backend.dto.user;

import java.util.UUID;

public record ResponseUserDto (
        UUID id,
        String name,
        String email,
        String biography,
        String image
){

}

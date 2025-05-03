package com.verbum.backend.mapper;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User RequestUserDtoToUser(RequestUserDto requestUserDto);
}
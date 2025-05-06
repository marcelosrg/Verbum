package com.verbum.backend.mapper;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.dto.ResponseUserDto;
import com.verbum.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User RequestUserDtoToUser(RequestUserDto requestUserDto);
    RequestUserDto UserToRequestUserDto(User user);
    User UpdateUser(ResponseUserDto responseUserDto);
    List<ResponseUserDto> UserToListUserDto(List<User> user);
}
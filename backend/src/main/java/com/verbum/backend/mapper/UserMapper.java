package com.verbum.backend.mapper;

import com.verbum.backend.dto.RequestUserDto;
import com.verbum.backend.dto.ResponseUserDto;
import com.verbum.backend.dto.UpdateUserDto;
import com.verbum.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User RequestUserDtoToUser(RequestUserDto requestUserDto);

    RequestUserDto UserToRequestUserDto(User user);

    void updateUserFromDto(UpdateUserDto dto, @MappingTarget User user);

    ResponseUserDto UserToResponseUserDto(User user);


    List<ResponseUserDto> UserToListUserDto(List<User> user);
}
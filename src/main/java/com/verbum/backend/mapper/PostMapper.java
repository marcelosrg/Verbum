package com.verbum.backend.mapper;

import com.verbum.backend.dto.post.RequestPostDto;
import com.verbum.backend.dto.post.ResponsePostDto;
import com.verbum.backend.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post RequestPostDtoToUser(RequestPostDto postDto);

    ResponsePostDto postToResponseDto(Post post);

}
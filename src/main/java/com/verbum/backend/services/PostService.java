package com.verbum.backend.services;

import com.verbum.backend.dto.post.RequestPostDto;
import com.verbum.backend.dto.post.ResponsePostDto;
import com.verbum.backend.mapper.PostMapper;
import com.verbum.backend.model.Post;
import com.verbum.backend.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository
                        , PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public ResponsePostDto create(RequestPostDto postDto){
        Post post = postMapper.RequestPostDtoToUser(postDto);
        postRepository.save(post);

        return postMapper.postToResponseDto(post);
    }
}

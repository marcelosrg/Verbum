package com.verbum.backend.controller;

import com.verbum.backend.dto.post.RequestPostDto;
import com.verbum.backend.dto.post.ResponsePostDto;
import com.verbum.backend.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/create")
    public ResponseEntity<ResponsePostDto> createPost(@RequestBody RequestPostDto requestPostDto) {
        ResponsePostDto createPost = postService.create(requestPostDto);
        return ResponseEntity
                .created(URI.create("/post/" + createPost.id()))
                .body(createPost);
    }
}

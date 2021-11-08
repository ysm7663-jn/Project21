package com.project.spring.springboot.web;

import com.project.spring.springboot.service.posts.PostsService;
import com.project.spring.springboot.web.dto.PostsResponseDto;
import com.project.spring.springboot.web.dto.PostsSaveRequestDto;
import com.project.spring.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // 1
// final 이 선언된 모든 필드를 인자값으로 하는 생성자들을 대신 생성해준다.

@RestController // 2
// @RequestBody 를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다

public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update (@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
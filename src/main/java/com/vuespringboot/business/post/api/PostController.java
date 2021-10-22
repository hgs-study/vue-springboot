package com.vuespringboot.business.post.api;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public String register(@RequestBody Post post){
        Post savedPost = postService.save(post);
        return savedPost.getTitle() + "의 글이 포스팅되었습니다.";
    }

    @GetMapping("/post/{id}")
    public Post getById(@PathVariable Long id){
        return postService.getById(id);
    }
}

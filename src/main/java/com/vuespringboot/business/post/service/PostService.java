package com.vuespringboot.business.post.service;

import com.vuespringboot.business.post.entity.Post;
import com.vuespringboot.business.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post getById(Long id){
        return postRepository.findById(id)
                             .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }
}
